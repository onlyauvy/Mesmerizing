package util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Mapper {
	public static List<Map<String, Object>> getObjectList(String keyStartWith) throws ParseException {

		List<Map<String, Object>> list = new ArrayList<>();
		
		if (Util.hasValue(keyStartWith + "no")) {
			//ok
		}
		else if(Util.hasValue(Util.getCommonString(keyStartWith+ "no"))) {
			keyStartWith = Util.getCommonString(keyStartWith)+".";
		}
		else 
			return list;
		
		int nos = Util.getIntegerValue(keyStartWith + "no");
		for (int i = 1; i <= nos; i++) {
			list.add(getObject(keyStartWith + i));
		}

		return list;
	}

	public static Map<String, Object> getObject(String keyStartWith) throws ParseException {

		Map<String, Object> map = new HashMap<String, Object>();
		Set<Object> set = ConfigData.properties.keySet();

		for (Object obj : set) {
			String str = obj.toString();
			
			if (str.startsWith(keyStartWith)) {
				// its ok
			} else if (str.startsWith(Util.getCommonString(keyStartWith))) {
				if(str.contains("{") && map.containsKey(str.substring(str.indexOf("{") + 1, str.indexOf("}"))))
					continue;
			} else 
				continue;

			
			if (str.contains(".(int)")) {
				map.put(str.substring(str.indexOf("{") + 1, str.indexOf("}")), Util.getIntegerValue(str));
			} else if (str.contains(".(bool)")) {
				map.put(str.substring(str.indexOf("{") + 1, str.indexOf("}")), Util.getBooleanValue(str));
			} else if (str.contains(".(str)")) {
				map.put(str.substring(str.indexOf("{") + 1, str.indexOf("}")), Util.getStringValue(str));
			} else if (str.contains(".(map)")) {
				map.put(str.substring(str.indexOf("{") + 1, str.indexOf("}")), getObject(Util.getStringValue(str)));
			} else if (str.contains(".(listmap)")) {
				map.put(str.substring(str.indexOf("{") + 1, str.indexOf("}")), getObjectList(Util.getStringValue(str)));
			}
			
		}

		return map;
	}
}
