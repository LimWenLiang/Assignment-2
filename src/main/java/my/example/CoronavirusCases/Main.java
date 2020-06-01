package my.example.CoronavirusCases;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {

    public static void main(String[] args) {
        final String url = "https://www.worldometers.info/coronavirus/";

        try {
            final Document document = Jsoup.connect(url).timeout(6000).get();

            for (Element row : document.select("div#nav-today.tab-pane.active tr")) {
                if (row.select("td:nth-child(1)").text().equals("")) {
                    continue;
                } else {
                    final String tempNumber = row.select("td:nth-child(1)").text();
                    final int number = Integer.parseInt(tempNumber);
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

                    String format = "%3s\t%-25s%-14s%-12s%-12s%-10s%-14s%-15s%-12s%-12s%-10s%-15s%-12s%s%n";
                    System.out.printf(format, number, country, totalCases, newCases, totalDeaths, newDeaths, totalRecovered, activeCases, seriousCritical, totCases_1Mpop, deaths_1Mpop, totalTests, tests_1Mpop, population);

                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
