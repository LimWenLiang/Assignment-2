package my.example.CoronavirusCases;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ListCoronaCases {

    private final String CoronaCasesLink = "https://www.worldometers.info/coronavirus/";
    private final String MalaysiaCases = "Malaysia";
    private final String IndonesiaCases = "Indonesia";
    private final String ChinaCases = "China";
    private Document document;
    private RegexMatches regexMatches;
    String format = "%9s\t%-12s%-12s%-12s%-11s%-14s%-12s%-12s%-14s%-12s%-12s%-10s%s%n";

    public void main() throws Exception {

        regexMatches = new RegexMatches();
        Scanner input = new Scanner(System.in);
        boolean stop = false;
        int number;

        document = Jsoup.connect(CoronaCasesLink).get();
        displayTime();
        displayTitle();

        do {
            Elements CoronaCases = document.select("table#main_table_countries_today");
            System.out.println("1. View Malaysia Cases");
            System.out.println("2. View Indonesia Cases");
            System.out.println("3. View China Cases");
            System.out.println("4. Return Main Menu");
            System.out.printf("Please select your choice(1/2/3/4): ");
            number = input.nextInt();
            System.out.println("");

            for (Element row : CoronaCases.select("tr")) {
                final String country = row.select("td:nth-child(2)").text();
                final String totalCases = row.select("td:nth-child(3)").text();
                final String newCases = row.select("td:nth-child(4)").text();
                final String totalDeaths = row.select("td:nth-child(5)").text();
                final String newDeaths = row.select("td:nth-child(6)").text();
                final String totalRecovered = row.select("td:nth-child(7)").text();
                final String activeCases = row.select("td:nth-child(9)").text();
                final String seriousCritical = row.select("td:nth-child(10)").text();
                final String totCases_1Mpop = row.select("td:nth-child(11)").text();
                final String deaths_1Mpop = row.select("td:nth-child(12)").text();
                final String totalTests = row.select("td:nth-child(13)").text();
                final String tests_1Mpop = row.select("td:nth-child(14)").text();
                final String population = row.select("td:nth-child(15)").text();

                if (number == 1) {
                    if (regexMatches.isMatch(MalaysiaCases, country) == true) {
                        displayTime();
                        System.out.println("Malaysia Cases Coronavirus Update (Live)");
                        displayCasesTitle();
                        System.out.printf(format, country, totalCases, newCases, totalDeaths, newDeaths, totalRecovered,
                                activeCases, seriousCritical, totCases_1Mpop, deaths_1Mpop, totalTests, tests_1Mpop, population);
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    }
                } else if (number == 2) {
                    if (regexMatches.isMatch(IndonesiaCases, country) == true) {
                        displayTime();
                        System.out.println("Indonesia Cases Coronavirus Update (Live)");
                        displayCasesTitle();
                        System.out.printf(format, country, totalCases, newCases, totalDeaths, newDeaths, totalRecovered,
                                activeCases, seriousCritical, totCases_1Mpop, deaths_1Mpop, totalTests, tests_1Mpop, population);
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

                    }
                } else if (number == 3) {
                    if (regexMatches.isMatch(ChinaCases, country) == true) {
                        displayTime();
                        System.out.println("China Cases Coronavirus Update (Live)");
                        displayCasesTitle();
                        System.out.printf(format, country, totalCases, newCases, totalDeaths, newDeaths, totalRecovered,
                                activeCases, seriousCritical, totCases_1Mpop, deaths_1Mpop, totalTests, tests_1Mpop, population);
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    }
                } else if (number == 4) {
                    stop = true;
                } else {
                    System.out.println("Invalid input, please try again.\n");
                    Thread.sleep(1000);
                    break;
                }
            }
        } while (stop != true);
    }

    public void displayTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println("Access Time: " + dateFormat.format(date));
    }

    public void displayTitle() {
        String title = document.title();
        System.out.println(title);
    }

    public void displayCasesTitle() {
        System.out.printf(format, "       ", "Total", "New", "Total", "New", "Total", "Active", "Serious", "Tot Cases/", "Deaths/", "Total", "Tests/", "          ");
        System.out.printf(format, "Country", "Cases", "Cases", "Death", "Death", "Recovered", "Cases", "Critical", "1M pop", "1M pop", "Tests", "1M pop", "Population");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
