package com.datscie.apponlineticketing;

import java.util.Scanner;

import com.datscie.apponlineticketing.model.Schedule;
import com.datscie.apponlineticketing.model.Seat;
import com.datscie.apponlineticketing.model.Ticket;
import com.datscie.apponlineticketing.model.auth.Admin;
import com.datscie.apponlineticketing.model.auth.User;

public class AppOnlineTicketing {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;
        while (true){
            System.out.println("-".repeat(50));
            System.out.println("Welcome to Online Ticketing App");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose menu: ");
            menu = scan.nextInt();

            if (menu == 1){
                System.out.println("-".repeat(50));
                System.out.println("Login");
                System.out.println("1. Admin");
                System.out.println("2. User");
                System.out.println("3. Back");
                System.out.print("Choose menu: ");
                int menuLogin = scan.nextInt();

                if (menuLogin == 1 ){
                    // LOGIN ADMIN
                    System.out.println("-".repeat(50));
                    System.out.println("Login Admin");
                    System.out.print("Email: ");
                    String email = scan.next();
                    System.out.print("Password: ");
                    String password = scan.next();
                    Admin admin = new Admin();
                    if (admin.login(email, password)){
                        System.out.println("Login Success");
                        System.out.println("-".repeat(50));
                        System.out.println("Welcome " + admin.getName());
                        while (true){
                            System.out.println("-".repeat(50));
                            System.out.println("1. Add Movie");
                            System.out.print("Choose menu: ");
                            int menuAdmin = scan.nextInt();
                            if (menuAdmin==1){
                                System.out.println("-".repeat(50));
                                System.out.println("Add Movie");
                                System.out.print("Title: ");
                                String title = scan.next();
                                System.out.print("Duration: ");
                                int duration = scan.nextInt();
                                System.out.print("Genre: ");
                                String genre = scan.next();
                                System.out.print("Director: ");
                                String director = scan.next();
                                admin.addMovie(title, genre, director, duration);
                            }
                        }
                    } else {
                        System.out.println("Login Failed");
                        continue;
                    }
                    // END LOGIN ADMIN
                }else if (menuLogin == 2){
                    // LOGIN USER
                    System.out.println("-".repeat(50));
                    System.out.println("Login User");
                    System.out.print("Email: ");
                    String email = scan.next();
                    System.out.print("Password: ");
                    String password = scan.next();
                    User user = new User();
                    if (user.login(email, password)){
                        System.out.println("Login Success");
                        System.out.println("-".repeat(50));
                        System.out.println("Welcome " + user.getName());
                        while (true){
                            System.out.println("-".repeat(50));
                            System.out.println("1. Buy Ticket");
                            System.out.println("2. Show Ticket");
                            System.out.println("3. Logout");
                            System.out.print("Choose menu: ");
                            int menuUser = scan.nextInt();
                            if (menuUser == 1){
                                // BUY TICKET
                                System.out.println("-".repeat(50));
                                System.out.println("Buy Ticket");
                                Schedule[] schedules = user.getAvailableSchedules();
                                for (int i = 0; i < schedules.length; i++){
                                    System.out.println((i+1) + ". " + schedules[i].getMovie().getTitle() + " - " + schedules[i].getStudio().getStudioId() + " - " + schedules[i].getDateTime());
                                }
                                System.out.print("Choose Schedule: ");
                                int scheduleIndex = scan.nextInt();
                                Schedule schedule = schedules[scheduleIndex-1];
                                Seat[] seats = schedule.getAvailableSeats();
                                for (int i = 0; i < seats.length; i++){
                                    System.out.println((i+1) + ". " + seats[i].getSeatID());
                                }
                                System.out.print("Choose Seat: ");
                                int seatIndex = scan.nextInt();
                                Seat seat = seats[seatIndex-1];
                                user.buyTicket(schedule, seat);
                                System.out.println("Buy Ticket Success");
                            } else if (menuUser == 2){
                                // SHOW TICKET
                                System.out.println("-".repeat(50));
                                System.out.println("Show Ticket");
                                Ticket[] tickets = user.getUserTickets();
                                for (int i = 0; i < tickets.length; i++){
                                    System.out.println((i+1) + ". " + tickets[i].getMovie().getTitle() + " - " + tickets[i].getStudio().getStudioId() + " - " + tickets[i].getDateTime() + " - " + tickets[i].getSeat().getSeatID());
                                }
                            }else if (menuUser == 3){
                                break;
                            }
                        }

                    } else {
                        System.out.println("Login Failed");
                        continue;
                    }
                    // END LOGIN USER

                }else{
                    continue;
                }
            } else if (menu == 2){
                // REGISTER (for user only)
                System.out.println("-".repeat(50));
                System.out.println("Register");
                System.out.print("Name: ");
                String name = scan.next();
                System.out.print("Email: ");
                String email = scan.next();
                System.out.print("Phone: ");
                String phone = scan.next();
                System.out.print("Password: ");
                String password = scan.next();
                User user = new User();
                user.register(name, email, phone, password);
                System.out.println("Register Success");
                // END REGISTER
                continue;
            } else if (menu == 3){
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Invalid Menu");
                continue;
            }
        }
        scan.close();
    }
}
