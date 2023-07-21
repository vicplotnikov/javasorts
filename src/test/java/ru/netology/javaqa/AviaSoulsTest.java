package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


class AviaSoulsTest {

    @Test
    public void testSortFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "VOR", 500, 9, 12);
        Ticket ticket2 = new Ticket("SPB", "MSK", 200, 10, 11);
        Ticket ticket3 = new Ticket("MSK", "NOV", 300, 12, 16);
        Ticket ticket4 = new Ticket("SPB", "MSK", 100, 11, 13);
        Ticket ticket5 = new Ticket("SPB", "MSK", 400, 13, 16);
        Ticket ticket6 = new Ticket("NOV", "KHB", 700, 14, 18);
        Ticket ticket7 = new Ticket("BER", "PAR", 900, 19, 21);
        Ticket ticket8 = new Ticket("SPB", "MSK", 100, 20, 23);
        Ticket ticket9 = new Ticket("SPB", "MSK", 300, 15, 18);
        Ticket ticket10 = new Ticket("SPB", "MSK", 700, 21, 24);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket4, ticket8, ticket2, ticket9, ticket5, ticket10};
        Ticket[] actual = manager.search("SPB", "MSK");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortNotTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "VOR", 500, 9, 12);
        Ticket ticket2 = new Ticket("SPB", "MSK", 200, 10, 11);
        Ticket ticket3 = new Ticket("MSK", "NOV", 300, 12, 16);
        Ticket ticket4 = new Ticket("SPB", "MSK", 100, 11, 13);
        Ticket ticket5 = new Ticket("SPB", "MSK", 400, 13, 16);
        Ticket ticket6 = new Ticket("NOV", "KHB", 700, 14, 18);
        Ticket ticket7 = new Ticket("BER", "PAR", 900, 19, 21);
        Ticket ticket8 = new Ticket("SPB", "MSK", 100, 20, 23);
        Ticket ticket9 = new Ticket("SPB", "MSK", 300, 15, 18);
        Ticket ticket10 = new Ticket("SPB", "MSK", 700, 21, 24);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("SPB", "PAR");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "VOR", 500, 9, 12);
        Ticket ticket2 = new Ticket("SPB", "MSK", 200, 10, 11);
        Ticket ticket3 = new Ticket("MSK", "NOV", 300, 12, 16);
        Ticket ticket4 = new Ticket("SPB", "MSK", 100, 11, 13);
        Ticket ticket5 = new Ticket("SPB", "MSK", 400, 13, 16);
        Ticket ticket6 = new Ticket("NOV", "KHB", 700, 14, 18);
        Ticket ticket7 = new Ticket("BER", "PAR", 900, 19, 21);
        Ticket ticket8 = new Ticket("SPB", "MSK", 100, 20, 23);
        Ticket ticket9 = new Ticket("SPB", "MSK", 300, 15, 18);
        Ticket ticket10 = new Ticket("SPB", "MSK", 700, 21, 24);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.search("NOV", "KHB");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortFewTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "VOR", 500, 9, 12);
        Ticket ticket2 = new Ticket("SPB", "MSK", 200, 10, 12);//2
        Ticket ticket3 = new Ticket("MSK", "NOV", 300, 12, 16);
        Ticket ticket4 = new Ticket("SPB", "MSK", 100, 11, 15); //4
        Ticket ticket5 = new Ticket("SPB", "MSK", 400, 13, 19); //6
        Ticket ticket6 = new Ticket("NOV", "KHB", 700, 14, 18);
        Ticket ticket7 = new Ticket("BER", "PAR", 900, 19, 21);
        Ticket ticket8 = new Ticket("SPB", "MSK", 100, 20, 21); //1
        Ticket ticket9 = new Ticket("SPB", "MSK", 300, 15, 18); //3
        Ticket ticket10 = new Ticket("SPB", "MSK", 700, 21, 26); //5

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket8, ticket2, ticket9, ticket4, ticket10, ticket5};
        Ticket[] actual = manager.search("SPB", "MSK", comparator);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortNotTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "VOR", 500, 9, 12);
        Ticket ticket2 = new Ticket("SPB", "MSK", 200, 10, 12);//2
        Ticket ticket3 = new Ticket("MSK", "NOV", 300, 12, 16);
        Ticket ticket4 = new Ticket("SPB", "MSK", 100, 11, 15); //4
        Ticket ticket5 = new Ticket("SPB", "MSK", 400, 13, 19); //6
        Ticket ticket6 = new Ticket("NOV", "KHB", 700, 14, 18);
        Ticket ticket7 = new Ticket("BER", "PAR", 900, 19, 21);
        Ticket ticket8 = new Ticket("SPB", "MSK", 100, 20, 21); //1
        Ticket ticket9 = new Ticket("SPB", "MSK", 300, 15, 18); //3
        Ticket ticket10 = new Ticket("SPB", "MSK", 700, 21, 26); //5

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("SPB", "PAR", comparator);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortOneTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "VOR", 500, 9, 12);
        Ticket ticket2 = new Ticket("SPB", "MSK", 200, 10, 12);//2
        Ticket ticket3 = new Ticket("MSK", "NOV", 300, 12, 16);
        Ticket ticket4 = new Ticket("SPB", "MSK", 100, 11, 15); //4
        Ticket ticket5 = new Ticket("SPB", "MSK", 400, 13, 19); //6
        Ticket ticket6 = new Ticket("NOV", "KHB", 700, 14, 18);
        Ticket ticket7 = new Ticket("BER", "PAR", 900, 19, 21);
        Ticket ticket8 = new Ticket("SPB", "MSK", 100, 20, 21); //1
        Ticket ticket9 = new Ticket("SPB", "MSK", 300, 15, 18); //3
        Ticket ticket10 = new Ticket("SPB", "MSK", 700, 21, 26); //5

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("MSK", "NOV", comparator);
        Assertions.assertArrayEquals(expected, actual);

    }


}