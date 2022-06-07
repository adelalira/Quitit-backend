package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.Achievement;
import com.example.demo.model.CommentCommunity;
import com.example.demo.model.MeetUp;
import com.example.demo.model.Penalty;
import com.example.demo.model.ScheduledMessage;
import com.example.demo.model.User;
import com.example.demo.repository.AchievementRepo;
import com.example.demo.repository.CommentsCommunityRepo;
import com.example.demo.repository.MeetUpRepo;
import com.example.demo.repository.PenaltyRepo;
import com.example.demo.repository.ScheduledMessageRepository;
import com.example.demo.repository.UserRepo;

@SpringBootApplication
@EnableScheduling
public class QuititApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(QuititApplication.class, args);
	}

	LocalDate fecha1 = LocalDate.parse("2022-04-20");
	LocalDateTime fecha2 = LocalDateTime.parse("2022-06-24T18:30:00");
	LocalDate fecha3 = LocalDate.parse("2022-02-20");
	LocalDate fecha4 = LocalDate.parse("2022-04-20");
	LocalDate fecha5 = LocalDate.parse("2022-03-20");
	LocalDate fecha6 = LocalDate.parse("2022-01-20");
	LocalDate fecha7 = LocalDate.parse("2022-05-20");

	@Bean
	CommandLineRunner initData(UserRepo repositorioUsers, CommentsCommunityRepo commentsCommunityRepo,
			MeetUpRepo meetUpRepo, AchievementRepo achievementRepo, PenaltyRepo penaltyRepo,
			ScheduledMessageRepository scheduledMessageRepo) {

		// Usuarios administradores
		User usuario1 = new User("Adela", "Lira", "adelalira", "adela@gmail.com", passwordEncoder.encode("12345"),
				"ADMIN", 3, 4.15);

		User usuario2 = new User("Laura", "Moreno", "lauramoreno", "laura@gmail.com", passwordEncoder.encode("12345"),
				"ADMIN", 7, 2.0);

		// Usuarios usuarios
		User usuarioUser1 = new User("Loli", "Montero", "lolimontero", "loli@gmail.com",
				passwordEncoder.encode("12345"), "USER", 17, 9.0, "https://res.cloudinary.com/lalalala/image/upload/v1651689445/foto_perfil_vo0omr.jpg");

		User usuarioUser2 = new User("Pepe", "Lopez", "pepitoloooooopez", "pepe@gmail.com",
				passwordEncoder.encode("12345"), "USER", 30, 10.30);

		User usuarioUser3 = new User("Pepi", "Montero", "pepimontero", "pepi@gmail.com",
				passwordEncoder.encode("12345"), "USER", 10, 5.0);

		User usuarioUser4 = new User("Ana", "JJ", "anita", "ani@gmail.com", passwordEncoder.encode("12345"), "USER", 5,
				2.0, "https://res.cloudinary.com/lalalala/image/upload/v1651689345/cld-sample.jpg");

		User usuarioUser5 = new User("Juan", "Garrido", "juanchus", "juanito@gmail.com",
				passwordEncoder.encode("12345"), "USER", 19, 12.0);

		User usuarioUser6 = new User("Adrián", "García", "elAdri", "adri@gmail.com", passwordEncoder.encode("12345"),
				"USER", 13, 8.0);

		User usuarioUser7 = new User("María", "Marín", "lamari", "lamari@gmail.com", passwordEncoder.encode("12345"),
				"USER", 11, 6.0);

		User usuarioUser8 = new User("Jonás", "Salazar", "elJoni", "joni@gmail.com", passwordEncoder.encode("12345"),
				"USER", 10, 5.0);

		usuarioUser1.addFriend(usuarioUser2);
		usuarioUser1.addFriend(usuarioUser3);
		usuarioUser1.addFriend(usuarioUser4);

		usuario1.setStartDate(fecha1);
		usuario2.setStartDate(fecha1);
		usuarioUser1.setStartDate(fecha3);
		usuarioUser2.setStartDate(fecha3);
		usuarioUser3.setStartDate(fecha4);
		usuarioUser4.setStartDate(fecha4);
		usuarioUser5.setStartDate(fecha5);
		usuarioUser6.setStartDate(fecha6);
		usuarioUser7.setStartDate(fecha7);
		usuarioUser8.setStartDate(fecha7);

		// Comentarios de la comunidad
		CommentCommunity comentarioComunidad1 = new CommentCommunity("Buenos dias!", usuarioUser1, fecha1);

		CommentCommunity comentarioComunidad2 = new CommentCommunity("Otro día más sumando!!!", usuarioUser2, fecha1);

		// MeetUps
		MeetUp meetUp1 = new MeetUp("Beers and sun without cigar!",
				"Beers and sun", fecha2,
				"100 Montaditos", "Face-to-face");

		// Logros
		Achievement logro1 = new Achievement("First cross on the calendar", "No smoking for one day", "certified.png",
				1, "days");
		Achievement logro2 = new Achievement("Step by step", "No smoking for 2 days", "4497660.png", 2, "days");
		Achievement logro3 = new Achievement("To infinity and beyond", "5 cigarettes non-smoked", "exito.png", 5,
				"cigarettes");
		Achievement logro4 = new Achievement("Superpowers", "You saved 20€", "growth.png", 20, "money");
		Achievement logro5 = new Achievement("Home is where my plants are", "No smoking for 5 days", "high-quality.png",
				5, "days");
		Achievement logro6 = new Achievement("Saturday night fever", "10 cigarettes non-smoked", "imagination.png", 10,
				"cigarettes");
		Achievement logro7 = new Achievement("Following the road", "No smoking for one week", "motivation.png", 7,
				"days");
		Achievement logro8 = new Achievement("Clothes off", "15 cigarettes non-smoked", "premium.png", 15,
				"cigarettes");
		Achievement logro9 = new Achievement("Less paper", "No smoking for 10 days", "prime.png", 10, "days");
		Achievement logro10 = new Achievement("Jump around", "20 cigarettes non-smoked", "struggle.png", 20,
				"cigarettes");
		Achievement logro11 = new Achievement("Crush the calendar", "No smoking for 2 weeks", "taekwondo.png", 14,
				"days");
		Achievement logro12 = new Achievement("Piggy bank", "You saved 100€", "piggybank.png", 100, "money");
		Achievement logro13 = new Achievement("Ballet on the city", "50 cigarettes non-smoked", "victoria.png", 50,
				"cigarettes");
		Achievement logro14 = new Achievement("First podium", "No smoking for 100 days", "success.png", 100, "days");
		Achievement logro15 = new Achievement("The mad vocalist", "No smoking for 100 days in a row", "karaoke.png",
				100, "daysInARow");
		Achievement logro16 = new Achievement("A sky full of posibilities", "No smoking for 200 days in a row",
				"stars.png", 200, "daysInARow");
		Achievement logro17 = new Achievement("Filthy rich", "You saved 300€", "rich.png", 300, "money");
		Achievement logro18 = new Achievement("Reinforcing your foundations", "500 cigarettes non-smoked",
				"brickwall.png", 500, "cigarettes");
		Achievement logro19 = new Achievement("To the Moon and back", "No smoking for 300 days in a row", "startup.png",
				300, "daysInARow");
		Achievement logro20 = new Achievement("Being your own vaccine", "500€ saved", "vaccinated.png", 500, "money");

		// Penalizaciones
		Penalty penalty1 = new Penalty("You lost your mind for a sec", "One smoking day", "alzheimer.png", 1, "days");
		Penalty penalty2 = new Penalty("You messed things up", "7 smoking days", "broken-heart.png", 7, "days");
		Penalty penalty3 = new Penalty("Don't leave your path", "1 cigarette smoked", "self-confidence.png", 1,
				"cigarette");
		Penalty penalty4 = new Penalty("Feel the force again", "7 cigarettes smoked", "judgment.png", 7, "cigarette");
		Penalty penalty5 = new Penalty("What are you doing?", "14 smoking days", "anxiety.png", 14, "days");
		Penalty penalty6 = new Penalty("You crossed the line", "14 cigarettes smoked", "decreased-concentration.png",
				14, "cigarette");
		Penalty penalty7 = new Penalty("Don't give up yet", "30 smoking days", "giveup.png", 30, "days");
		Penalty penalty8 = new Penalty("Pull over and come back", "30 cigarettes smoked", "stop-sign.png", 30,
				"cigarette");
		Penalty penalty9 = new Penalty("Where are you going?", "40 cigarettes smoked", "question.png", 40, "cigarette");
		Penalty penalty10 = new Penalty("Quit it now!", "40 smoking days", "alzheimer.png", 40, "day");
		Penalty penalty11 = new Penalty("Dude...", "50 smoking days", "alzheimer.png", 50, "day");
		Penalty penalty12 = new Penalty("Quit it now!", "40 cigarettes smoked", "alzheimer.png", 50, "cigarette");
		Penalty penalty13 = new Penalty("Are you proud?", "60 smoking days", "alzheimer.png", 60, "day");
		Penalty penalty14 = new Penalty("Save your words for the judge", "60 cigarettes smoked", "alzheimer.png", 60,
				"cigarette");
		Penalty penalty15 = new Penalty("Fight!", "70 smoking days", "atlas.png", 70, "day");
		Penalty penalty16 = new Penalty("This is war!", "80 cigarettes smoked", "alzheimer.png", 80, "cigarette");
		Penalty penalty17 = new Penalty("Try again ...", "80  smoking days", "alzheimer.png", 80, "days");
		Penalty penalty18 = new Penalty("Come on...", "90 cigarettes smoked", "alzheimer.png", 90, "cigarette");
		Penalty penalty19 = new Penalty("What if you ready try it this time?", "90  smoking days", "alzheimer.png", 90,
				"days");
		Penalty penalty20 = new Penalty("You're letting me down", "100 cigarettes smoked", "alzheimer.png", 100,
				"cigarette");

		// SCHEDULED MESSAGES
		ScheduledMessage sm1 = new ScheduledMessage("GREAT JOB! You haven't smoked for DAYS days", true);
		ScheduledMessage sm2 = new ScheduledMessage("You got this! You haven't smoked for DAYSINAROW days in a row",
				false);
		ScheduledMessage sm3 = new ScheduledMessage(
				"Good luck today! I know you’ll do great. You've avoided CIGARETTES cigarettes", false);
		ScheduledMessage sm4 = new ScheduledMessage("Sending major good vibes your way. You've earned MONEY€!", false);
		ScheduledMessage sm5 = new ScheduledMessage(
				"I know this won’t be easy, but I also know you’ve got what it takes to get through it. You haven't smoked for DAYSINAROW days in a row",
				false);
		ScheduledMessage sm6 = new ScheduledMessage("Time to go kick cancer’s ass!", false);
		ScheduledMessage sm7 = new ScheduledMessage(
				"Sending you good thoughts—and hoping you believe in yourself just as much as we believe in you. You have avoided CIGARETTES cigarettes",
				false);
		ScheduledMessage sm8 = new ScheduledMessage(
				"We hope you feel your inner strength building day by day. You have earned MONEY€", false);
		ScheduledMessage sm9 = new ScheduledMessage(
				"This is tough, but you’re tougher. You haven't smoked for DAYS days", false);
		ScheduledMessage sm10 = new ScheduledMessage(
				"We're proud of you for walking this road, for doing what’s right for you. You have avoided CIGARETTES cigarettes!",
				false);
		ScheduledMessage sm11 = new ScheduledMessage(
				"You’re making a big change, and that’s a really big deal. You haven't smoked for DAYSINAROW days in a row",
				false);
		ScheduledMessage sm12 = new ScheduledMessage(
				"Even when you might not feel it, you’ve got the strength to get through. You haven't smoked for DAYS days",
				false);
		ScheduledMessage sm13 = new ScheduledMessage(
				"Take everything one day at a time. You've avoided CIGARETTES cigarettes. That's awesome!", false);
		ScheduledMessage sm14 = new ScheduledMessage(
				"It takes serious courage to get on this path and stay on it. Good on you. You've already earned MONEY€!",
				false);
		ScheduledMessage sm15 = new ScheduledMessage("Awesome! You've earned MONEY€", false);
		ScheduledMessage sm16 = new ScheduledMessage("Keep on keeping on! You haven'r smoked for DAYS days", false);

		return (args) -> {

			repositorioUsers.saveAll(Arrays.asList(usuario1, usuario2, usuarioUser1, usuarioUser2, usuarioUser3,
					usuarioUser4, usuarioUser5, usuarioUser6, usuarioUser7, usuarioUser8));

			commentsCommunityRepo.saveAll(Arrays.asList(comentarioComunidad1, comentarioComunidad2));

			meetUpRepo.saveAll(Arrays.asList(meetUp1));

			achievementRepo.saveAll(
					Arrays.asList(logro1, logro2, logro3, logro4, logro5, logro6, logro7, logro8, logro9, logro10,
							logro11, logro12, logro13, logro14, logro15, logro16, logro17, logro18, logro19, logro20));

			penaltyRepo.saveAll(Arrays.asList(penalty1, penalty2, penalty3, penalty4, penalty5, penalty6, penalty7,
					penalty8, penalty9, penalty10, penalty11, penalty12, penalty13, penalty14, penalty15, penalty16,
					penalty17, penalty18, penalty19, penalty20));

			scheduledMessageRepo.saveAll(Arrays.asList(sm1, sm2, sm3, sm4, sm5, sm6, sm7, sm8, sm9, sm10, sm11, sm12,
					sm13, sm14, sm15, sm16));

		};
	}
////https://res.cloudinary.com/lalalala/image/upload/v1651857335/quitIt_userImages/zhbsrm2ocu3pfyd9edgl.jpg
}
