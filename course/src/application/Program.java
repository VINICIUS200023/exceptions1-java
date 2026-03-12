package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	// Resolução ruim

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = scanner.nextInt();

		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(scanner.next(), fmt);

		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(scanner.next(), fmt);

		if (!checkOut.isAfter(checkIn)) {
			System.out.println("Erro in reservation: Check-out date must be after check-in date");
		} else {

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");

			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(scanner.next(), fmt);

			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(scanner.next(), fmt);

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Erro in reservation: " + error);
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation:" + reservation);
			}

		}

	}

}
