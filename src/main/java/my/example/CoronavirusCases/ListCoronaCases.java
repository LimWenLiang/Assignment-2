package my.example.CoronavirusCases;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListCoronaCases {

    private final String CoronaCasesLink = "https://www.worldometers.info/coronavirus/";
    private final String MalaysiaCase = "Malaysia";
    private final String IndonesiaCase = "Indonesia";
    private final String ChinaCase = "China";
    private Document document;
    private RegexMatches regexMatches;

    public void main() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        regexMatches = new RegexMatches();
        String format = "%9s\t%-12s%-12s%-12s%-11s%-14s%-12s%-12s%-14s%-12s%-10s%-12s%s%n";

        try {

            document = Jsoup.connect(CoronaCasesLink).get();
            String title = document.title();
            System.out.println(title);
            System.out.println("Current Time: " + dateFormat.format(date) + "\n");
            System.out.printf(format, "       ", "Total", "New", "Total", "New", "Total", "Active", "Serious", "Tot Cases/", "Deaths/", "Total", "Tests/", "          ");
            System.out.printf(format, "Country", "Cases", "Cases", "Death", "Death", "Recovered", "Cases", "Critical", "1M pop", "1M pop", "Tests", "1M pop", "Population");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");

            Elements CoronaCases = document.select("div#nav-today.tab-pane.active tr");
            for (Element row : CoronaCases) {
                final String country = row.select("td:nth-child(2)").text();
                final String totalCases = row.select("td:nth-child(3)").text();
                final String newCases = row.select("td:nth-child(4)").text();
                final String totalDeaths = row.select("td:nth-child(5)").text();
                final String newDeaths = row.select("td:nth-child(6)").text();
                final String totalRecovered = row.select("td:nth-child(7)").text();
                final String activeCases = row.select("td:nth-child(8)").text();
                final String seriousCritical = row.select("td:nth-child(9)").text();
                final String totCases_1Mpop = row.select("td:nth-child(10)").text();
                final String deaths_1Mpop = row.select("td:nth-child(11)").text();
                final String totalTests = row.select("td:nth-child(12)").text();
                final String tests_1Mpop = row.select("td:nth-child(13)").text();
                final String population = row.select("td:nth-child(14)").text();

                // display Malaysia cases
                if (regexMatches.isMatch(MalaysiaCase, country) == true) {
                    System.out.printf(format, country, totalCases, newCases, totalDeaths, newDeaths, totalRecovered,
                            activeCases, seriousCritical, totCases_1Mpop, deaths_1Mpop, totalTests, tests_1Mpop, population);
                }

                // display Indonesia cases
                if (regexMatches.isMatch(IndonesiaCase, country) == true) {
                    System.out.printf(format, country, totalCases, newCases, totalDeaths, newDeaths, totalRecovered,
                            activeCases, seriousCritical, totCases_1Mpop, deaths_1Mpop, totalTests, tests_1Mpop, population);
                }

                // display China cases
                if (regexMatches.isMatch(ChinaCase, country) == true) {
                    System.out.printf(format, country, totalCases, newCases, totalDeaths, newDeaths, totalRecovered,
                            activeCases, seriousCritical, totCases_1Mpop, deaths_1Mpop, totalTests, tests_1Mpop, population);
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
