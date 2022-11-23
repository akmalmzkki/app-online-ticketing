package com.datscie.apponlineticketing.utils;

import java.util.List;

import com.datscie.apponlineticketing.model.Movie;
import com.datscie.apponlineticketing.model.Studio;
import com.datscie.apponlineticketing.model.Ticket;
import com.datscie.apponlineticketing.model.auth.User;

public class DatabaseMock {
    public List<Movie> movies;
    public List<Studio> studios;
    public List<Ticket> tickets;
    public List<User> users;

    private static DatabaseMock db = null;

    public static DatabaseMock getInstance() {
        if (db == null)
            db = new DatabaseMock();
  
        return db;
    }

    public Movie[] getMovies() {
        return movies.toArray(new Movie[movies.size()]);
    }

    public Movie getMovie(String movieID) {
        for (Movie movie : movies) {
            if (movie.getMovieId().equals(movieID))
                return movie;
        }

        return null;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void editMovie(Movie movie) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getMovieId().equals(movie.getMovieId())) {
                movies.set(i, movie);
                break;
            }
        }
    }

    public void deleteMovie(String movieId) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getMovieId().equals(movieId)) {
                movies.remove(i);
                break;
            }
        }
    }

    public Studio[] getStudios() {
        return studios.toArray(new Studio[studios.size()]);
    }

    public Studio getStudio(String studioID) {
        for (Studio studio : studios) {
            if (studio.getStudioId().equals(studioID))
                return studio;
        }

        return null;
    }

    public void addStudio(Studio studio) {
        studios.add(studio);
    }

    public void editStudio(Studio studio) {
        for (int i = 0; i < studios.size(); i++) {
            if (studios.get(i).getStudioId().equals(studio.getStudioId())) {
                studios.set(i, studio);
                break;
            }
        }
    }

    public void deleteStudio(String studioId) {
        for (int i = 0; i < studios.size(); i++) {
            if (studios.get(i).getStudioId().equals(studioId)) {
                studios.remove(i);
                break;
            }
        }
    }

    public Ticket[] getTickets() {
        return tickets.toArray(new Ticket[tickets.size()]);
    }

    public Ticket getTicket(String ticketID) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketID().equals(ticketID))
                return ticket;
        }

        return null;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void editTicket(Ticket ticket) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getTicketID().equals(ticket.getTicketID())) {
                tickets.set(i, ticket);
                break;
            }
        }
    }

    public void deleteTicket(String ticketId) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getTicketID().equals(ticketId)) {
                tickets.remove(i);
                break;
            }
        }
    }

    public User[] getUsers() {
        return users.toArray(new User[users.size()]);
    }

    public User getUser(String userID) {
        for (User user : users) {
            if (user.getId().equals(userID))
                return user;
        }

        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void editUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                break;
            }
        }
    }

    public void deleteUser(String userId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(userId)) {
                users.remove(i);
                break;
            }
        }
    }
}