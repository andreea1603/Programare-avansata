package com;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

public class DisplayLocales {

    public static void main(String[] args) {
        System.out.println("Default locale:");
        //localeInfo(Locale.getDefault());
        System.out.println("Available locales:");
        Locale[] available =
                Locale.getAvailableLocales();
        for(Locale locale : available) {

            try {
                System.out.println("Aici");
                System.out.println("\t" + locale.getDisplayCountry() + "\t" +
                        locale.getDisplayLanguage(locale)
                        + "\t"
                );

            } catch (Exception e) {
                System.out.println("Nu am gasit tara");
            }
            System.out.println();
            try {
                Currency currency = Currency.getInstance(locale);
                System.out.println(currency.getCurrencyCode());

            } catch (Exception e) {
                System.out.println("nu");
            }
            DateFormatSymbols symbols = new DateFormatSymbols(locale);
            String[] days = symbols.getWeekdays();
            String[] months = symbols.getMonths();
            System.out.println("Days:");
            for (int i = 0; i < days.length; i++) {
                System.out.print("\t" + days[i] + "  ");
            }
            System.out.println("Months: ");
            for (int i = 0; i < days.length; i++) {
                System.out.println("\t" + months[i] + " ");
            }
        }
            }
        }
