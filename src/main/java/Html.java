public abstract class Html {

    public static final String htmlHeader = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
            "<html>\n" +
            "  <head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
            "    <title>Weather email</title>\n" +
            "    <style type=\"text/css\">\n" +
            "      .appleLink a {\n" +
            "        color: #000000 !important;\n" +
            "        text-decoration: none;\n" +
            "      }\n" +
            "      div, p, a, li, td {\n" +
            "        -webkit-text-size-adjust: none;\n" +
            "      }\n" +
            "    </style>\n" +
            "  </head>\n" +
            "  <body>\n" +
            "\n" +
            "<table style=\"width: 100%; border-spacing: 3px;\">";

    public static final String dayStart = "  <tr>\n" +
            "  <td style=\"padding: 3px;\">\n" +
            "\n" +
            "    <!-- START OF TABLE FOR DAY 1 -->\n" +
            "    <table id=\"day1\" style=\"margin-left: auto; margin-right: auto; border-spacing: 3px; " +
            "font-size: 12px; font-family: Verdana, Arial, sans-serif; text-align: center; margin-bottom: 20px\">";

    public static final String day1Title = "<tr style=\"height: 30px; font-weight: bold\">\n" +
            "        <td colspan=\"5\" style=\"padding-left: 10px; border-top: 2px solid #000; border-" +
            "bottom: 2px solid #000; background-color: #FFF; text-align: left; font-size: 14px\"><span " +
            "class=\"appleLink\">TODAY ($Day)</span></td>\n" +
            "      </tr>";

    public static final String day2Title = "<tr style=\"height: 30px; font-weight: bold\">\n" +
            "        <td colspan=\"5\" style=\"padding-left: 10px; border-top: 2px solid #000; border-" +
            "bottom: 2px solid #000; background-color: #FFF; text-align: left; font-size: 14px\"><span " +
            "class=\"appleLink\">TOMORROW ($Day)</span></td>\n" +
            "      </tr>";

    public static final String dayTableHeaders = "      <tr style=\"height: 25px; color: #777;\">\n" +
            "        <th style=\"width: 70px; font-weight: bold\">Time</th>\n" +
            "        <th style=\"width: 165px; font-weight: bold\">Weather</th>\n" +
            "        <th style=\"width: 80px; font-weight: bold\">Temp.</th>\n" +
            "        <th style=\"width: 65px; font-weight: bold\">Rain</th>\n" +
            "        <th style=\"width: 85px; font-weight: bold\">Wind</th>\n" +
            "      </tr>";

    // $Name = fields for inserting weather forecast elements in
    // $Color = hex colour code for weather type
    // $TextColor = hex colour code for text color (black or white)
    // $Time = e.g. 'Midnight'
    // $WeatherType = e.g. 'Cloudy'
    // $Temp = e.g. '23'
    // $FeelsLike = e.g. '21'
    // $Rain = e.g. '10'
    // $Wind = e.g. '15'
    // $Gusts = e.g. '35'
    public static final String hourForecast = "      <tr style=\"height: 25px; background-color: $Color; color: $TextColor;\">\n" +
            "        <td><span class=\"appleLink\">$Time</span></td>\n" +
            "        <td><span class=\"appleLink\">$WeatherType</span></td>\n" +
            "        <td><span class=\"appleLink\">$Temp ($FeelsLike)</span></td>\n" +
            "        <td><span class=\"appleLink\">$Rain%</span></td>\n" +
            "        <td><span class=\"appleLink\">$Wind ($Gusts)</span></td>\n" +
            "      </tr>";

    public static final String day1End = "</table>\n" +
            "    <!-- END OF TABLE FOR DAY 1 -->\n" +
            "\n" +
            "  </td>\n" +
            "  </tr>";


    public static final String day2End = "      <tr>\n" +
            "        <td colspan=\"5\" style=\"padding: 1px\">\n" +
            "          <table id=\"key\" style=\"margin-top: 10px; font-size: 8px; font-family: Verdana, Arial, sans-serif; color: #777\">\n" +
            "            <tr>\n" +
            "              <td colspan=\"3\" style=\"padding: 1px; text-align: left;\">Key:</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "              <td style=\"text-align: right;\">Temp.</td>\n" +
            "              <td>=</td>\n" +
            "              <td style=\"text-align: left;\">temperature (feels like), in &#176;C</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "              <td style=\"text-align: right;\">Rain</td>\n" +
            "              <td>=</td>\n" +
            "              <td style=\"text-align: left;\">chance of rain</td>\n" +
            "            </tr>\n" +
            "            <tr>\n" +
            "              <td style=\"text-align: right;\">Wind</td>\n" +
            "              <td>=</td>\n" +
            "              <td style=\"text-align: left;\">wind speed (gusts), in mph</td>\n" +
            "            </tr>\n" +
            "          </table>\n" +
            "        </td>\n" +
            "      </tr>\n" +
            "\n" +
            "\n" +
            "    </table>\n" +
            "    <!-- END OF TABLE FOR DAY 2 -->\n" +
            "\n" +
            "  </td>\n" +
            "  </tr>\n" +
            "\n" +
            "</table>\n" +
            "</body>\n" +
            "\n" +
            "</html>";

}
