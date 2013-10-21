package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Legal telephone types.
 * @author marc
 *
 */
public class TelephoneTypes {
  
  private static String[] types = {"Home", "Work", "Mobile"};

  /**
   *
   * @return the type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<>();
    for (String type: types) {
      typeMap.put(type, false);
    }
    return typeMap;
  }

  /**
   *
   * @param telType the type.
   * @return typemap.
   */
  public static Map<String, Boolean> getTypes(String telType) {
    Map<String, Boolean> typeMap = TelephoneTypes.getTypes();
    if (isType(telType)) {
      typeMap.put(telType, true);
    }
    return typeMap;
  }

  /**
   *
   * @param telType the type.
   * @return telephone type.
   */
  public static boolean isType(String telType) {
    return TelephoneTypes.getTypes().keySet().contains(telType);
  }

}
