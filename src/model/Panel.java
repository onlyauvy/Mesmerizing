package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Panel {
	private Map<String, Object> aliasColors= new HashMap<>();
	private boolean bars;
	private int dashLength;
	private boolean dashes;
	private String datasource;
	private Map<String, Object> fieldConfig= new HashMap<>();
	private int fill;
	private int fillGradient;
	private Map<String, Object> gridPos= new HashMap<>();
	private boolean hiddenSeries;
	private int id;
	private Map<String, Object> legend= new HashMap<>();
	private boolean lines;
	private int linewidth;
	private String nullPointMode;
	private Map<String, Object> options= new HashMap<>();
	private boolean percentage;
	private String pluginVersion;
	private int pointradius;
	private boolean points;
	private String renderer;
	private List<Map<String, Object>> seriesOverrides = new ArrayList<>();
	private int spaceLength;
	private boolean stack;
	private boolean steppedLine;
	private List<Map<String, Object>> targets = new ArrayList<>();
	private List<Map<String, Object>> thresholds = new ArrayList<>();
	private String timeFrom;
	private List<Map<String, Object>> timeRegions = new ArrayList<>();
	private String timeShift;
	private String title;
	private Map<String, Object> tooltip= new HashMap<>();
	private String type;
	private Map<String, Object> xaxis = new HashMap<>();
	private List<Map<String, Object>> yaxes = new ArrayList<>();
	private Map<String, Object> yaxis= new HashMap<>();

	
	public Map<String, Object> getAliasColors() {
		return aliasColors;
	}
	public void setAliasColors(Map<String, Object> aliasColors) {
		this.aliasColors = aliasColors;
	}
	public boolean isBars() {
		return bars;
	}
	public void setBars(boolean bars) {
		this.bars = bars;
	}
	public int getDashLength() {
		return dashLength;
	}
	public void setDashLength(int dashLength) {
		this.dashLength = dashLength;
	}
	public boolean isDashes() {
		return dashes;
	}
	public void setDashes(boolean dashes) {
		this.dashes = dashes;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	
	
	public Map<String, Object> getFieldConfig() {
		return fieldConfig;
	}
	public void setFieldConfig(Map<String, Object> fieldConfig) {
		this.fieldConfig = fieldConfig;
	}
	public int getFill() {
		return fill;
	}
	public void setFill(int fill) {
		this.fill = fill;
	}
	public int getFillGradient() {
		return fillGradient;
	}
	public void setFillGradient(int fillGradient) {
		this.fillGradient = fillGradient;
	}
	
	public Map<String, Object> getGridPos() {
		return gridPos;
	}
	public void setGridPos(Map<String, Object> gridPos) {
		this.gridPos = gridPos;
	}
	
	public boolean isHiddenSeries() {
		return hiddenSeries;
	}
	public void setHiddenSeries(boolean hiddenSeries) {
		this.hiddenSeries = hiddenSeries;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isLines() {
		return lines;
	}
	public Map<String, Object> getLegend() {
		return legend;
	}
	public void setLegend(Map<String, Object> legend) {
		this.legend = legend;
	}
	public void setLines(boolean lines) {
		this.lines = lines;
	}
	public int getLinewidth() {
		return linewidth;
	}
	public void setLinewidth(int linewidth) {
		this.linewidth = linewidth;
	}
	
	public Map<String, Object> getOptions() {
		return options;
	}
	public void setOptions(Map<String, Object> options) {
		this.options = options;
	}
	public String getNullPointMode() {
		return nullPointMode;
	}
	public void setNullPointMode(String nullPointMode) {
		this.nullPointMode = nullPointMode;
	}
	public boolean isPercentage() {
		return percentage;
	}
	public void setPercentage(boolean percentage) {
		this.percentage = percentage;
	}
	public String getPluginVersion() {
		return pluginVersion;
	}
	public void setPluginVersion(String pluginVersion) {
		this.pluginVersion = pluginVersion;
	}
	public int getPointradius() {
		return pointradius;
	}
	public void setPointradius(int pointradius) {
		this.pointradius = pointradius;
	}
	public boolean isPoints() {
		return points;
	}
	public void setPoints(boolean points) {
		this.points = points;
	}
	public String getRenderer() {
		return renderer;
	}
	public void setRenderer(String renderer) {
		this.renderer = renderer;
	}
	
	public List<Map<String, Object>> getSeriesOverrides() {
		return seriesOverrides;
	}
	public void setSeriesOverrides(List<Map<String, Object>> seriesOverrides) {
		this.seriesOverrides = seriesOverrides;
	}
	public int getSpaceLength() {
		return spaceLength;
	}
	public void setSpaceLength(int spaceLength) {
		this.spaceLength = spaceLength;
	}
	public boolean isStack() {
		return stack;
	}
	public void setStack(boolean stack) {
		this.stack = stack;
	}
	public boolean isSteppedLine() {
		return steppedLine;
	}
	public void setSteppedLine(boolean steppedLine) {
		this.steppedLine = steppedLine;
	}
	
	public List<Map<String, Object>> getTargets() {
		return targets;
	}
	public void setTargets(List<Map<String, Object>> targets) {
		this.targets = targets;
	}
	public List<Map<String, Object>> getThresholds() {
		return thresholds;
	}
	public void setThresholds(List<Map<String, Object>> thresholds) {
		this.thresholds = thresholds;
	}

	public String getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}
	
	public List<Map<String, Object>> getTimeRegions() {
		return timeRegions;
	}
	public void setTimeRegions(List<Map<String, Object>> timeRegions) {
		this.timeRegions = timeRegions;
	}
	public String getTimeShift() {
		return timeShift;
	}
	public void setTimeShift(String timeShift) {
		this.timeShift = timeShift;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Map<String, Object> getTooltip() {
		return tooltip;
	}
	public void setTooltip(Map<String, Object> tooltip) {
		this.tooltip = tooltip;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Map<String, Object> getXaxis() {
		return xaxis;
	}
	public void setXaxis(Map<String, Object> xaxis) {
		this.xaxis = xaxis;
	}
	public List<Map<String, Object>> getYaxes() {
		return yaxes;
	}
	public void setYaxes(List<Map<String, Object>> yaxes) {
		this.yaxes = yaxes;
	}
	public Map<String, Object> getYaxis() {
		return yaxis;
	}
	public void setYaxis(Map<String, Object> yaxis) {
		this.yaxis = yaxis;
	}
	
}

