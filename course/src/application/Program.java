package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = scanner.nextInt();

			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(scanner.next(), fmt);

			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(scanner.next(), fmt);

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");

			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(scanner.next(), fmt);

			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(scanner.next(), fmt);

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

		} catch (DateTimeParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

	}

}
