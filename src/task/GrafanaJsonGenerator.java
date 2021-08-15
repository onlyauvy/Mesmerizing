package task;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Grafana;
import model.Panel;
import util.ConfigData;
import util.Mapper;
import util.Util;

public class GrafanaJsonGenerator {
	
	private Grafana grafana;
	
	public GrafanaJsonGenerator() {
		grafana = new Grafana();
	}
	
	/**
	 * Create the json file
	 * @param filePath= properties file path
	 * @param outputPath= where to generate the output json
	 * @param fileName= json file name
	 * */
	public void generate(String propertisefilePath, String outputPath, String fileName) throws IOException, FileNotFoundException, ParseException {
		
		try (InputStream input = new FileInputStream(propertisefilePath)) 
		{
			ConfigData.properties.load(input);

			setCommonData();
			setPanelsData();
			
			Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
			
			
			//Check the path
			File file = new File(outputPath);
			boolean dirCreated = file.mkdir();
			
			if(dirCreated)System.out.println("Creating path: "+outputPath);
			
			
			Writer  writer = Files.newBufferedWriter(Paths.get(outputPath+"/"+fileName));
			gson.toJson(grafana, writer);
			writer.close();
		}
		catch (FileNotFoundException e) {
			throw new FileNotFoundException("config.properties file not found.");
		}
		
	}
	
	
	/**
	 * Generate the json string
	 * 
	 * @param propertisefilePath= properties file path
	 * */
	public String generate(String propertisefilePath) throws IOException, FileNotFoundException, ParseException {
		
		try (InputStream input = new FileInputStream(propertisefilePath)) 
		{
			ConfigData.properties.load(input);

			setCommonData();
			setPanelsData();
			
			Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
			return gson.toJson(grafana);
		}
		catch (FileNotFoundException e) {
			throw new FileNotFoundException("config.properties file not found.");
		}
		
	}

	private void setPanelsData() throws ParseException {
		
		List<Panel> panels = new ArrayList<>();
		int panelNo = Util.getIntegerValue("panel.no");
		
		for(int panelPos=1; panelPos<=panelNo; panelPos++) {
			panels.add(setPanel(panelPos));
		}
		
		grafana.setPanels(panels);
	}
	
	
	
	private Map<String, Object> getGridPos(int panelPos) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("h",9);
		map.put("w",12);
		map.put("x",panelPos%2==0?12:0);
		map.put("y",((panelPos-1)/2)*9);
		return map;
	}

	
	private Panel setPanel(int panelPos) throws ParseException {
		Panel panel = new Panel();

		panel.setAliasColors(Mapper.getObject("panel."+panelPos+".aliasColors."));
		
		panel.setFieldConfig(Mapper.getObject("panel."+panelPos+".fieldConfig."));
		
		
		//setting data autometically
		panel.setGridPos(getGridPos(panelPos));
		//panel.setGridPos(Mapper.getObject("panel."+panelPos+".gridPos."));
		
		panel.setOptions(Mapper.getObject("panel."+panelPos+".options."));
		
		panel.setSeriesOverrides(Mapper.getObjectList("panel."+panelPos+".seriesOverrides."));
		
		panel.setTargets(Mapper.getObjectList("panel."+panelPos+".targets."));
		
		panel.setThresholds(Mapper.getObjectList("panel."+panelPos+".thresholds."));
		
		panel.setTimeRegions(Mapper.getObjectList("panel."+panelPos+".timeRegions."));
		
		panel.setLegend(Mapper.getObject("panel."+panelPos+".legend."));
		
		panel.setTooltip(Mapper.getObject("panel."+panelPos+".tooltip."));
		
		panel.setXaxis(Mapper.getObject("panel."+panelPos+".xaxis."));
		
		panel.setYaxes(Mapper.getObjectList("panel."+panelPos+".yaxes."));
		
		panel.setYaxis(Mapper.getObject("panel."+panelPos+".yaxis."));

		
		if(Util.hasValue("panel."+panelPos+".bars") || Util.hasValue("panel.common.bars"))
			panel.setBars(Util.currentTmpValueAsBoolean()); 
		
		if(Util.hasValue("panel."+panelPos+".dashLength")|| Util.hasValue("panel.common.dashLength"))
			panel.setDashLength(Util.currentTmpValueAsInteger());

		if(Util.hasValue("panel."+panelPos+".dashes")|| Util.hasValue("panel.common.dashes"))
			panel.setDashes(Util.currentTmpValueAsBoolean());
		
		if(Util.hasValue("panel."+panelPos+".datasource")|| Util.hasValue("panel.common.datasource"))
			panel.setDatasource(Util.currentTmpValueAsString());
		
		if(Util.hasValue("panel."+panelPos+".fill")|| Util.hasValue("panel.common.fill"))
			panel.setFill(Util.currentTmpValueAsInteger());

		if(Util.hasValue("panel."+panelPos+".fillGradient")|| Util.hasValue("panel.common.fillGradient"))
			panel.setFillGradient(Util.currentTmpValueAsInteger());

		if(Util.hasValue("panel."+panelPos+".hiddenSeries")|| Util.hasValue("panel.common.hiddenSeries"))
			panel.setHiddenSeries(Util.currentTmpValueAsBoolean());

		if(Util.hasValue("panel."+panelPos+".id")|| Util.hasValue("panel.common.id"))
			panel.setId(Util.currentTmpValueAsInteger());

		if(Util.hasValue("panel."+panelPos+".lines")|| Util.hasValue("panel.common.lines"))
			panel.setLines(Util.currentTmpValueAsBoolean());

		if(Util.hasValue("panel."+panelPos+".linewidth")|| Util.hasValue("panel.common.linewidth"))
			panel.setLinewidth(Util.currentTmpValueAsInteger());

		if(Util.hasValue("panel."+panelPos+".nullPointMode")|| Util.hasValue("panel.common.nullPointMode"))
			panel.setNullPointMode(Util.currentTmpValueAsString());

		if(Util.hasValue("panel."+panelPos+".percentage")|| Util.hasValue("panel.common.percentage"))
			panel.setPercentage(Util.currentTmpValueAsBoolean());
		
		if(Util.hasValue("panel."+panelPos+".pluginVersion")|| Util.hasValue("panel.common.pluginVersion"))
			panel.setPluginVersion(Util.currentTmpValueAsString());

		if(Util.hasValue("panel."+panelPos+".pointradius")|| Util.hasValue("panel.common.pointradius"))
			panel.setPointradius(Util.currentTmpValueAsInteger());

		if(Util.hasValue("panel."+panelPos+".points")|| Util.hasValue("panel.common.points"))
			panel.setPoints(Util.currentTmpValueAsBoolean());

		if(Util.hasValue("panel."+panelPos+".renderer")|| Util.hasValue("panel.common.renderer"))
			panel.setRenderer(Util.currentTmpValueAsString());

		if(Util.hasValue("panel."+panelPos+".spaceLength")|| Util.hasValue("panel.common.spaceLength"))
			panel.setSpaceLength(Util.currentTmpValueAsInteger());

		if(Util.hasValue("panel."+panelPos+".stack")|| Util.hasValue("panel.common.stack"))
			panel.setStack(Util.currentTmpValueAsBoolean());

		if(Util.hasValue("panel."+panelPos+".steppedLine")|| Util.hasValue("panel.common.steppedLine"))
			panel.setSteppedLine(Util.currentTmpValueAsBoolean());
		
		if(Util.hasValue("panel."+panelPos+".timeFrom")|| Util.hasValue("panel.common.timeFrom"))
			panel.setTimeFrom(Util.getStringValue("panel."+panelPos+".timeFrom"));

		if(Util.hasValue("panel."+panelPos+".timeShift")|| Util.hasValue("panel.common.timeShift"))
			panel.setTimeShift(Util.currentTmpValueAsString());

		if(Util.hasValue("panel."+panelPos+".title")|| Util.hasValue("panel.common.title"))
			panel.setTitle(Util.currentTmpValueAsString());

		if(Util.hasValue("panel."+panelPos+".type")|| Util.hasValue("panel.common.type"))
			panel.setType(Util.currentTmpValueAsString());
		
		return panel;
	}
	
	
	private void setCommonData() throws ParseException 
	{
		
		grafana.setAnnotations(Mapper.getObject("annotations."));
		
		grafana.setLinks(Mapper.getObjectList("links."));
		
		grafana.setLinks(Mapper.getObjectList("tags."));
		
		grafana.setTemplating(Mapper.getObject("templating"));
		
		grafana.setTime(Mapper.getObject("time."));
		
		grafana.setTimepicker(Mapper.getObject("timepicker."));
		
		if(Util.hasValue("editable"))
			grafana.setEditable(Util.currentTmpValueAsBoolean()); 
		
		if(Util.hasValue("gnetId")) 
			grafana.setGnetId(Util.currentTmpValueAsString()); 
		
		if(Util.hasValue("graphTooltip")) 
			grafana.setGraphTooltip(Util.currentTmpValueAsInteger()); 
		
		if(Util.hasValue("id")) 
			grafana.setId(Util.currentTmpValueAsInteger()); 
		
		if(Util.hasValue("refresh"))
			grafana.setRefresh(Util.currentTmpValueAsBoolean()); 
		
		if(Util.hasValue("refresh"))
			grafana.setRefresh(Util.currentTmpValueAsBoolean());
		
		if(Util.hasValue("schemaVersion"))
			grafana.setSchemaVersion(Util.currentTmpValueAsInteger());
		
		if(Util.hasValue("style"))
			grafana.setStyle(Util.currentTmpValueAsString());
		
		if(Util.hasValue("timezone"))
			grafana.setTimezone(Util.currentTmpValueAsString());
		
		if(Util.hasValue("title"))
			grafana.setTitle(Util.currentTmpValueAsString());
		
		if(Util.hasValue("uid"))
			grafana.setUid(Util.currentTmpValueAsString());
		
		if(Util.hasValue("version"))
			grafana.setVersion(Util.currentTmpValueAsInteger());

	}
}
