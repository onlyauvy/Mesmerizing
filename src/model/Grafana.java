package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafana {
	private Map<String, Object> annotations = new HashMap<String, Object>();
	private boolean editable=true;
	private String gnetId;
	private int graphTooltip;
	private int id;
	private List<Map<String, Object>> links = new ArrayList<>();
	private List<Panel> panels = new ArrayList<>();
	private boolean refresh;
	private int schemaVersion;
	private String style;
	private List<Map<String, Object>> tags = new ArrayList<>();
	private Map<String, Object> templating= new HashMap<>();
	private Map<String, Object> time = new HashMap<String, Object>();
	private Map<String, Object> timepicker= new HashMap<>();
	private String timezone="";
	private String title;
	private String uid;
	private int version;

	
	public Map<String, Object> getAnnotations() {
		return annotations;
	}
	public void setAnnotations(Map<String, Object> annotations) {
		this.annotations = annotations;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public String getGnetId() {
		return gnetId;
	}
	public void setGnetId(String gnetId) {
		this.gnetId = gnetId;
	}
	public int getGraphTooltip() {
		return graphTooltip;
	}
	public void setGraphTooltip(int graphTooltip) {
		this.graphTooltip = graphTooltip;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Map<String, Object>> getLinks() {
		return links;
	}
	public void setLinks(List<Map<String, Object>> links) {
		this.links = links;
	}
	public List<Panel> getPanels() {
		return panels;
	}
	public void setPanels(List<Panel> panels) {
		this.panels = panels;
	}
	public boolean isRefresh() {
		return refresh;
	}
	public void setRefresh(boolean refresh) {
		this.refresh = refresh;
	}
	public int getSchemaVersion() {
		return schemaVersion;
	}
	public void setSchemaVersion(int schemaVersion) {
		this.schemaVersion = schemaVersion;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	public List<Map<String, Object>> getTags() {
		return tags;
	}
	public void setTags(List<Map<String, Object>> tags) {
		this.tags = tags;
	}
	public Map<String, Object> getTemplating() {
		return templating;
	}
	public void setTemplating(Map<String, Object> templating) {
		this.templating = templating;
	}
	public Map<String, Object> getTime() {
		return time;
	}
	public void setTime(Map<String, Object> time) {
		this.time = time;
	}
	public Map<String, Object> getTimepicker() {
		return timepicker;
	}
	public void setTimepicker(Map<String, Object> timepicker) {
		this.timepicker = timepicker;
	}

	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
}