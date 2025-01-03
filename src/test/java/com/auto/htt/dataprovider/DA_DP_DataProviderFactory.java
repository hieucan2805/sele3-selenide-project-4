//package com.auto.htt.dataprovider;
//
//
//import com.auto.model.profile.ProfileModel;
//import com.auto.model.user.UserModel;
//import com.auto.utils.Constants;
//import com.auto.utils.FileUtils;
//import com.auto.utils.JsonUtils;
//import com.google.gson.JsonObject;
//import org.testng.annotations.DataProvider;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static com.auto.test.dataprovider.DA_PANEL_DataProviderFactory.*;
//
//public class DA_DP_DataProviderFactory {
//
//    private static String profileJSONPath = FileUtils.getCurrentDir() + Constants.PROFILE_JSON_DATA_PATH_ROOT;
//    private static JsonObject profileDataObject = JsonUtils.getJsonObjects(profileJSONPath);
//    private static String profileDropdownDataJSONPath = FileUtils.getCurrentDir() + Constants.PROFILE_JSON_DROPDOWN_DATA_PATH_ROOT;
//    private static JsonObject profileDropdownDataObject = JsonUtils.getJsonObjects(profileDropdownDataJSONPath);
//
//
//    @DataProvider(name = "profileTesT")
//    public static Object[][] createProfileTest() {
//        JsonObject profileData = profileDataObject.getAsJsonObject("PROFILE_TEST");
//
//        ProfileModel profile = JsonUtils.convertJsonToObjects(profileData, ProfileModel.class);
//        return new Object[][]{
//                {profile}
//        };
//    }
//
//    @DataProvider(name = "profileWithDisplayNameFieldHasSpecialCharactersExcept@")
//    public static Object[][] createProfileWithDisplayNameFieldHasSpecialCharactersExceptATSymbol() {
//        JsonObject profileData = profileDataObject.getAsJsonObject("PROFILE_WITH_DISPLAY_NAME_FIELD_HAS_SPECIAL_CHARACTERS_EXCEPT_@");
//
//        ProfileModel profile = JsonUtils.convertJsonToObjects(profileData, ProfileModel.class);
//        return new Object[][]{
//                {profile}
//        };
//    }
//
//    @DataProvider(name = "profileWithDisplayNameFieldHasSpecialCharactersIs@")
//    public static Object[][] createProfileWithDisplayNameFieldHasSpecialCharactersIsATSymbol() {
//        JsonObject profileData = profileDataObject.getAsJsonObject("PROFILE_WITH_DISPLAY_NAME_FIELD_HAS_SPECIAL_CHARACTERS_IS_@");
//
//        ProfileModel profile = JsonUtils.convertJsonToObjects(profileData, ProfileModel.class);
//        return new Object[][]{
//                {profile}
//        };
//    }
//
//    @DataProvider(name = "profileTestModule")
//    public static Object[][] createProfileTestModule() {
//        JsonObject profileData = profileDataObject.getAsJsonObject("PROFILE_TEST_TYPE_TEST_MODULE");
//
//        ProfileModel profile = JsonUtils.convertJsonToObjects(profileData, ProfileModel.class);
//        return new Object[][]{
//                {profile}
//        };
//    }
//
//    @DataProvider(name = "DA_DP_TC065")
//    public static Object[][] DA_DP_TC065_DataProvider() {
//        UserModel validUser = (UserModel) DA_LOGIN_DataProviderFactory.validUser2DataProvider()[0][0];
//
//        String[] chartsPanel = JsonUtils.convertJsonArrayToArray(dropdownDataPanelPromptObject, "CHART_PANELS");
//        String[] indicatorsPanel = JsonUtils.convertJsonArrayToArray(dropdownDataPanelPromptObject, "INDICATOR_PANELS");
//        String[] reportsPanel = JsonUtils.convertJsonArrayToArray(dropdownDataPanelPromptObject, "REPORTS_PANELS");
//        String[] heatMapsPanel = JsonUtils.convertJsonArrayToArray(dropdownDataPanelPromptObject, "HEAT_MAP_PANELS");
//
//        List<String> listDataProfiles = new ArrayList<>();
//        Collections.addAll(listDataProfiles, chartsPanel);
//        Collections.addAll(listDataProfiles, indicatorsPanel);
//        Collections.addAll(listDataProfiles, reportsPanel);
//        Collections.addAll(listDataProfiles, heatMapsPanel);
//        Collections.sort(listDataProfiles);
//
//        return new Object[][]{
//                {validUser, listDataProfiles}
//        };
//    }
//
//    @DataProvider(name = "DA_DP_TC068")
//    public static Object[][] DA_DP_TC068_DataProvider() {
//        UserModel validUser = (UserModel) DA_LOGIN_DataProviderFactory.validUser2DataProvider()[0][0];
//        ProfileModel profile = (ProfileModel) createProfileTest()[0][0];
//
//        String[] chartsPanel = JsonUtils.convertJsonArrayToArray(dropdownDataPanelPromptObject, "CHART_PANELS");
//        String[] indicatorsPanel = JsonUtils.convertJsonArrayToArray(dropdownDataPanelPromptObject, "INDICATOR_PANELS");
//        String[] reportsPanel = JsonUtils.convertJsonArrayToArray(dropdownDataPanelPromptObject, "REPORTS_PANELS");
//        String[] heatMapsPanel = JsonUtils.convertJsonArrayToArray(dropdownDataPanelPromptObject, "HEAT_MAP_PANELS");
//
//        List<String> listDataProfiles = new ArrayList<>();
//        Collections.addAll(listDataProfiles, chartsPanel);
//        Collections.addAll(listDataProfiles, indicatorsPanel);
//        Collections.addAll(listDataProfiles, reportsPanel);
//        Collections.addAll(listDataProfiles, heatMapsPanel);
//        Collections.sort(listDataProfiles);
//
//        return new Object[][]{
//                {validUser, profile, listDataProfiles}
//        };
//    }
//
//    @DataProvider(name = "DA_DP_TC070")
//    public static Object[][] DA_DP_TC070_DataProvider() {
//        UserModel validUser = (UserModel) DA_LOGIN_DataProviderFactory.validUser2DataProvider()[0][0];
//        ProfileModel profile = (ProfileModel) createProfileWithDisplayNameFieldHasSpecialCharactersExceptATSymbol()[0][0];
//
//        return new Object[][]{
//                {validUser, profile}
//        };
//    }
//
//    @DataProvider(name = "DA_DP_TC071")
//    public static Object[][] DA_DP_TC071_DataProvider() {
//        UserModel validUser = (UserModel) DA_LOGIN_DataProviderFactory.validUser2DataProvider()[0][0];
//        ProfileModel profile = (ProfileModel) createProfileTest()[0][0];
//
//        return new Object[][]{
//                {validUser, profile}
//        };
//    }
//
//    @DataProvider(name = "DA_DP_TC072")
//    public static Object[][] DA_DP_TC072_DataProvider() {
//        UserModel validUser = (UserModel) DA_LOGIN_DataProviderFactory.validUser2DataProvider()[0][0];
//        String[] itemTypes = JsonUtils.convertJsonArrayToArray(profileDropdownDataObject, "GENERAL_SETTING_ITEM_TYPES");
//
//        List<String> listItemTypes = Arrays.asList(itemTypes);
//
//        return new Object[][]{
//                {validUser, listItemTypes}
//        };
//    }
//
//    @DataProvider(name = "DA_DP_TC078")
//    public static Object[][] DA_DP_TC078_DataProvider() {
//        UserModel validUser = (UserModel) DA_LOGIN_DataProviderFactory.validUser2DataProvider()[0][0];
//        ProfileModel profile = (ProfileModel) createProfileTest()[0][0];
//        String[] displayFields = JsonUtils.convertJsonArrayToArray(profileDropdownDataObject, "DISPLAY_FIELDS");
//
//        List<String> listDisplayFields = Arrays.asList(displayFields);
//
//        return new Object[][]{
//                {validUser, profile, listDisplayFields}
//        };
//    }
//
//    @DataProvider(name = "DA_DP_TC096")
//    public static Object[][] DA_DP_TC096_DataProvider() {
//        UserModel validUser = (UserModel) DA_LOGIN_DataProviderFactory.validUser2DataProvider()[0][0];
//        ProfileModel profile = (ProfileModel) createProfileTestModule()[0][0];
//
//        return new Object[][]{
//                {validUser, profile}
//        };
//    }
//}
