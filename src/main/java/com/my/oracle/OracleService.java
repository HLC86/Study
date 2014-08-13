package com.my.oracle;
public class OracleService {}
//package com.my.oracle;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.AbstractMap.SimpleEntry;
//import java.util.TreeMap;
//
//import javax.annotation.Resource;
//
//import oracle.jdbc.OracleTypes;
//import oracle.sql.DATE;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.SqlParameter;
//import org.springframework.jdbc.core.simple.SimpleJdbcCall;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OracleService {
//	private @Resource(name = "jdbcDev") JdbcTemplate template;
//	private Map<String, Object> paramsEntity = new HashMap<String, Object>();
//	private static final LinkedHashMap<String, SimpleEntry<String, Integer>> namesAndTypeEntity = new LinkedHashMap<String, SimpleEntry<String, Integer>>() {
//		{
//			put("p_domain_name", new SimpleEntry<String, Integer>("p_domain_name", OracleTypes.VARCHAR));
//			put("conceptId_qcode", new SimpleEntry<String, Integer>("p_code", OracleTypes.VARCHAR));
//			put("type_qcode", new SimpleEntry<String, Integer>("p_entity_type", OracleTypes.VARCHAR));
//			put("p_english_name", new SimpleEntry<String, Integer>("p_english_name", OracleTypes.VARCHAR));
//			put("p_english_definition", new SimpleEntry<String, Integer>("p_english_definition", OracleTypes.VARCHAR));
//			put("stage_current", new SimpleEntry<String, Integer>("p_stage", OracleTypes.VARCHAR));
//			put("stage_date", new SimpleEntry<String, Integer>("p_stage_date", OracleTypes.DATE));
//			put("appliesTo_profile", new SimpleEntry<String, Integer>("p_applies_to", OracleTypes.VARCHAR));
//			put("created", new SimpleEntry<String, Integer>("p_created", OracleTypes.DATE));
//			put("isContentGrouping", new SimpleEntry<String, Integer>("p_is_content_grouping", OracleTypes.VARCHAR));
//			put("isIsoHistorical", new SimpleEntry<String, Integer>("p_is_iso_historical", OracleTypes.VARCHAR));
//			put("isNotForThirdPartyUse", new SimpleEntry<String, Integer>("p_is_not_for_third_party_use", OracleTypes.VARCHAR));
//			put("isForThirdPartyUseOnly", new SimpleEntry<String, Integer>("p_is_for_third_party_use_only", OracleTypes.VARCHAR));
//			put("additionalCodes", new SimpleEntry<String, Integer>("p_additional_codes", OracleTypes.VARCHAR));
//			put("isNotForDisplay", new SimpleEntry<String, Integer>("p_is_not_for_display", OracleTypes.VARCHAR));
//		}
//	};
//
//	private static List<SqlParameter> list = new ArrayList<SqlParameter>();
//	//private static SqlParameter[] pList = new SqlParameter[namesAndTypeEntity.size()];
//	static {
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_domain_name").getKey(), namesAndTypeEntity.get("p_domain_name").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_code").getKey(), namesAndTypeEntity.get("p_code").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_entity_type").getKey(), namesAndTypeEntity.get("p_entity_type").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_english_name").getKey(), namesAndTypeEntity.get("p_english_name").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_english_definition").getKey(), namesAndTypeEntity.get("p_english_definition").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_stage").getKey(), namesAndTypeEntity.get("p_stage").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_stage_date").getKey(), namesAndTypeEntity.get("p_stage_date").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_applies_to").getKey(), namesAndTypeEntity.get("p_applies_to").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_created").getKey(), namesAndTypeEntity.get("p_created").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_is_content_grouping").getKey(), namesAndTypeEntity.get("p_is_content_grouping").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_is_iso_historical").getKey(), namesAndTypeEntity.get("p_is_iso_historical").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_is_not_for_third_party_use").getKey(), namesAndTypeEntity.get("p_is_not_for_third_party_use").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_is_for_third_party_use_only").getKey(), namesAndTypeEntity.get("p_is_for_third_party_use_only").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_additional_codes").getKey(), namesAndTypeEntity.get("p_additional_codes").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_is_not_for_display").getKey(), namesAndTypeEntity.get("p_is_not_for_display").getValue()));
//
//				int i =0;
//		for (String key : namesAndTypeEntity.keySet()) {
//			list.add(new SqlParameter(namesAndTypeEntity.get(key).getKey(), namesAndTypeEntity.get(key).getValue()));
//			//pList[i] = new SqlParameter(namesAndTypeEntity.get(key).getKey(), namesAndTypeEntity.get(key).getValue());
//			i++;
//		}
//	}
//
//	private SqlParameter[] pSqlParameters = new SqlParameter[] {
//			new SqlParameter("p_domain_name", OracleTypes.VARCHAR),
//			new SqlParameter("p_code", OracleTypes.VARCHAR),
//			new SqlParameter("p_entity_type", OracleTypes.VARCHAR),
//			new SqlParameter("p_english_name", OracleTypes.VARCHAR),
//			new SqlParameter("p_english_definition", OracleTypes.VARCHAR),
//			new SqlParameter("p_stage", OracleTypes.VARCHAR),
//			new SqlParameter("p_stage_date", OracleTypes.DATE),
//			new SqlParameter("p_applies_to", OracleTypes.VARCHAR),
//			new SqlParameter("p_created", OracleTypes.DATE),
//			new SqlParameter("p_is_content_grouping", OracleTypes.VARCHAR),
//			new SqlParameter("p_is_iso_historical", OracleTypes.VARCHAR),
//			new SqlParameter("p_is_not_for_third_party_use", OracleTypes.VARCHAR),
//			new SqlParameter("p_is_for_third_party_use_only", OracleTypes.VARCHAR),
//			new SqlParameter("p_additional_codes", OracleTypes.VARCHAR),
//			new SqlParameter("p_is_not_for_display", OracleTypes.VARCHAR) };
//
//	private void getArgs(SqlParameter ...parameters) {
//		System.out.println("---->>>>");
//		for (SqlParameter p : parameters) {
//			System.out.println(p.getName() + ":" + p.getSqlType());
//		}
//	}
//
//	public void test2() {
//		getArgs(list.toArray(new SqlParameter[0]));
//	}
//
//	public void test3() {
//		getArgs(
//				new SqlParameter("p_domain_name",OracleTypes.VARCHAR),
//				new SqlParameter("p_code",OracleTypes.VARCHAR),
//				new SqlParameter("p_entity_type",OracleTypes.VARCHAR),
//				new SqlParameter("p_english_name",OracleTypes.VARCHAR),
//				new SqlParameter("p_english_definition",OracleTypes.VARCHAR),
//				new SqlParameter("p_stage",OracleTypes.VARCHAR),
//				new SqlParameter("p_stage_date",OracleTypes.DATE),
//				new SqlParameter("p_applies_to",OracleTypes.VARCHAR),
//				new SqlParameter("p_created",OracleTypes.DATE),
//				new SqlParameter("p_is_content_grouping",OracleTypes.VARCHAR),
//				new SqlParameter("p_is_iso_historical",OracleTypes.VARCHAR),
//				new SqlParameter("p_is_not_for_third_party_use",OracleTypes.VARCHAR),
//				new SqlParameter("p_is_for_third_party_use_only",OracleTypes.VARCHAR),
//				new SqlParameter("p_additional_codes",OracleTypes.VARCHAR),
//				new SqlParameter("p_is_not_for_display",OracleTypes.VARCHAR));
//	}
//
//	public void test() {
//
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_domain_name").getKey(), namesAndTypeEntity.get("p_domain_name").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("conceptId_qcode").getKey(), namesAndTypeEntity.get("conceptId_qcode").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("type_qcode").getKey(), namesAndTypeEntity.get("type_qcode").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_english_name").getKey(), namesAndTypeEntity.get("p_english_name").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("p_english_definition").getKey(), namesAndTypeEntity.get("p_english_definition").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("stage_current").getKey(), namesAndTypeEntity.get("stage_current").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("stage_date").getKey(), namesAndTypeEntity.get("stage_date").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("appliesTo_profile").getKey(), namesAndTypeEntity.get("appliesTo_profile").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("created").getKey(), namesAndTypeEntity.get("created").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("isContentGrouping").getKey(), namesAndTypeEntity.get("isContentGrouping").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("isIsoHistorical").getKey(), namesAndTypeEntity.get("isIsoHistorical").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("isNotForThirdPartyUse").getKey(), namesAndTypeEntity.get("isNotForThirdPartyUse").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("isForThirdPartyUseOnly").getKey(), namesAndTypeEntity.get("isForThirdPartyUseOnly").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("additionalCodes").getKey(), namesAndTypeEntity.get("additionalCodes").getValue()));
////		list.add(new SqlParameter(namesAndTypeEntity.get("isNotForDisplay").getKey(), namesAndTypeEntity.get("isNotForDisplay").getValue()));
//
//
//
//		//Arrays.eq
//		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(template);
//		simpleJdbcCall.withoutProcedureColumnMetaDataAccess()
//		.withCatalogName("pkg_load_rcs")
//		.withProcedureName("insert_entity")
//		//.declareParameters(pList);
//		//.declareParameters(Arrays.asList(pSqlParameters).toArray(new SqlParameter[0]));
//		.declareParameters(list.toArray(new SqlParameter[0]));
//
//		java.util.Date date = null;
//		try {
//			date = new SimpleDateFormat("yyyy-MM-dd").parse("1900-01-01");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		java.sql.Date date2 = new java.sql.Date(date.getTime());
//		DATE sqlDate = new DATE(date2);
//		paramsEntity.put("p_domain_name", "agriculture");
//		paramsEntity.put("p_code", "M:1");
//		paramsEntity.put("p_entity_type", "cptType:49");
//		paramsEntity.put("p_english_name", null);
//		paramsEntity.put("p_english_definition", null);
//		paramsEntity.put("p_stage", "stg:live");
//		paramsEntity.put("p_stage_date", null);
//		paramsEntity.put("p_applies_to", null);
//		paramsEntity.put("p_created", sqlDate);
//		paramsEntity.put("p_is_content_grouping", "isContentGrouping");
//		paramsEntity.put("p_is_iso_historical", null);
//		paramsEntity.put("p_is_not_for_third_party_use", null);
//		paramsEntity.put("p_is_for_third_party_use_only", null);
//		paramsEntity.put("p_additional_codes", null);
//		paramsEntity.put("p_is_not_for_display", null);
//
//		simpleJdbcCall.execute(paramsEntity);
//	}
//}
