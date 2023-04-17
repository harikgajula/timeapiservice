package com.ghk.demo.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TimezoneUtils {
	
	private static final List<String> US_TIMEZONES = Arrays.asList("America/Adak", "America/Anchorage",
			"America/Araguaina", "America/Argentina/Buenos_Aires", "America/Argentina/Catamarca",
			"America/Argentina/Cordoba", "America/Argentina/Jujuy", "America/Argentina/La_Rioja",
			"America/Argentina/Mendoza", "America/Argentina/Rio_Gallegos", "America/Argentina/Salta",
			"America/Argentina/San_Juan", "America/Argentina/San_Luis", "America/Argentina/Tucuman",
			"America/Argentina/Ushuaia", "America/Asuncion", "America/Bahia", "America/Bahia_Banderas",
			"America/Barbados", "America/Belem", "America/Belize", "America/Boa_Vista", "America/Bogota",
			"America/Boise", "America/Cambridge_Bay", "America/Campo_Grande", "America/Cancun", "America/Caracas",
			"America/Cayenne", "America/Chicago", "America/Chihuahua", "America/Ciudad_Juarez", "America/Costa_Rica",
			"America/Cuiaba", "America/Danmarkshavn", "America/Dawson", "America/Dawson_Creek", "America/Denver",
			"America/Detroit", "America/Edmonton", "America/Eirunepe", "America/El_Salvador", "America/Fort_Nelson",
			"America/Fortaleza", "America/Glace_Bay", "America/Goose_Bay", "America/Grand_Turk", "America/Guatemala",
			"America/Guayaquil", "America/Guyana", "America/Halifax", "America/Havana", "America/Hermosillo",
			"America/Indiana/Indianapolis", "America/Indiana/Knox", "America/Indiana/Marengo",
			"America/Indiana/Petersburg", "America/Indiana/Tell_City", "America/Indiana/Vevay",
			"America/Indiana/Vincennes", "America/Indiana/Winamac", "America/Inuvik", "America/Iqaluit",
			"America/Jamaica", "America/Juneau", "America/Kentucky/Louisville", "America/Kentucky/Monticello",
			"America/La_Paz", "America/Lima", "America/Los_Angeles", "America/Maceio", "America/Managua",
			"America/Manaus", "America/Martinique", "America/Matamoros", "America/Mazatlan", "America/Menominee",
			"America/Merida", "America/Metlakatla", "America/Mexico_City", "America/Miquelon", "America/Moncton",
			"America/Monterrey", "America/Montevideo", "America/New_York", "America/Nome", "America/Noronha",
			"America/North_Dakota/Beulah", "America/North_Dakota/Center", "America/North_Dakota/New_Salem",
			"America/Nuuk", "America/Ojinaga", "America/Panama", "America/Paramaribo", "America/Phoenix",
			"America/Port-au-Prince", "America/Porto_Velho", "America/Puerto_Rico", "America/Punta_Arenas",
			"America/Rankin_Inlet", "America/Recife", "America/Regina", "America/Resolute", "America/Rio_Branco",
			"America/Santarem", "America/Santiago", "America/Santo_Domingo", "America/Sao_Paulo",
			"America/Scoresbysund", "America/Sitka", "America/St_Johns", "America/Swift_Current", "America/Tegucigalpa",
			"America/Thule", "America/Tijuana", "America/Toronto", "America/Vancouver", "America/Whitehorse",
			"America/Winnipeg", "America/Yakutat");

	public static List<String> getUSTimezones() {
		return Collections.unmodifiableList(US_TIMEZONES);
	}
}
