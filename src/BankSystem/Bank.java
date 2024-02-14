package BankSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bank implements IAccount {
	private Scanner scanner;
	private List<Bank> list;
	private Random random;
	private Bank account;

	public Bank() {
		list = new ArrayList<>();
		random = new Random();

	}

	@Override
	public void getBalance(Bank person) {
		System.out.println(person.getbalance() + person.getName());

	}

	@Override
	public void getID(Bank person) {
		System.out.println(person.getId());

	}

	@Override
	public void benefit(Bank person) {
		int thisYear = 2023;
		double yearlyBenefit = (person.getbalance() - person.getBalanceAtStart())
				/ (thisYear - person.getYearOfBalanceStart());
		double dailyBenefit = yearlyBenefit / 365;
		System.out.println("yıllık kâr : " + yearlyBenefit);
		System.out.println("günlük kâr : " + dailyBenefit);
	}
	//

	@Override
	public void registerNewUser(Bank person) {

		list.add(person);

	}

	@Override
	public void getAccounts() {

		for (Bank account : list) {
			System.out.println(account.getId() + " " + account.getbalance());

		}
	}

	public void showIDs() {

		for (Bank account : list) {
			System.out.println(account.getId());
		}
	}

	@Override
	public void getDate() {
		System.out.println(formattedDate);

	}

	public void deposit() {
		String id;
		int cash;
		scanner = new Scanner(System.in);
		id = scanner.nextLine();
		scanner = new Scanner(System.in);
		cash = scanner.nextInt();

		for (Bank account : list) {
			
				int islem = account.getbalance() +cash;
				account.setBalance(islem);
				System.out.println(account.getbalance());
				System.out.println(now);}

	}

	@Override
	public void transaction() {
		while (true) {
			System.out.println("\n---------------------------------\n");
			System.out.println("1-Create_S_ID_balance(Hesap no, başlangıç parası)");
			System.out.println("2-Create_L_ID_balance(Hesap no, başlangıç parası)");
			System.out.println("3-Create_O_ID_balance(Hesap no, başlangıç parası)");
			System.out.println("4-Create_C_ID_balance(Hesap no, başlangıç parası)");
			System.out.println("5-Increase_ID_cash(Id)");
			System.out.println("6-Decrease_ID_cash(Id)");
			System.out.println("7-Show Accounts information");
			System.out.println("8-Show ID's");
			System.out.println("9-Sort the winner");
			System.out.println("10-show live time");
			System.out.println("11-exit");
			scanner = new Scanner(System.in);
			int number = scanner.nextInt();

			switch (number) {
			case 1:
				createNewAccount(1);

				break;
			case 2:
				createNewAccount(2);
				break;
			case 3:
				createNewAccount(3);
				break;
			case 4:
				createNewAccount(4);
				break;
			case 5:
				System.out.println(
						"lütfen önce para yatırmak istediğiniz hesabın idsini sonra ise para miktarını giriniz");
				scanner = new Scanner(System.in);
				String id = scanner.nextLine();
				int cash = scanner.nextInt();

				deposit();
				break;
			case 6:
				System.out
						.println("lütfen önce para çekmek istediğiniz hesabın idsini sonra ise para miktarını giriniz");

				withdraw();
				break;
			case 7:
				getAccounts();
				break;
			case 8:
				showIDs();
				break;
			case 9:
				sortition();
				break;
			case 10:
				getDate();
				System.out.println("bu saaat güncellenmiştir, yeni saat " + now + " dır.");

			default:
				break;
			}

		}

	}

	@Override
	public void createNewAccount(int number) {
		scanner = new Scanner(System.in);

		if (number == 1) {
			System.out.println("kısa vadeli hesap açılıyor");
			System.out.println("lütfen id giriniz");
			id = scanner.nextLine();
			System.out.println("lütfen bakiye giriniz");
			int accountBalance = scanner.nextInt();
			if (accountBalance >= 1000) {
				account = new ShortTerm(id, accountBalance);
				account.setBalance(accountBalance);
				account.setId(id);
				list.add(account);
				registerNewUser(account);
				System.out.println("hesap oluşturuldu");

			} else {
				System.out.println("bakiyeniz yetersizdir");

			}

		} else if (number == 2) {
			System.out.println("uzun vadeli hesap açılıyor");
			System.out.println("lütfen id giriniz");
			id = scanner.nextLine();
			System.out.println("lütfen bakiye giriniz");
			int accountBalance = scanner.nextInt();
			if (accountBalance >= 1500) {
				account = new ShortTerm(id, accountBalance);
				account.setBalance(accountBalance);
				account.setId(id);
				list.add(account);
				registerNewUser(account);
				System.out.println("hesap oluşturuldu");

			} else {
				System.out.println("bakiyeniz yetersizdir");

			}

		} else if (number == 3) {
			System.out.println("özel hesap açılıyor");
			System.out.println("lütfen id giriniz");
			id = scanner.nextLine();
			System.out.println("lütfen bakiye giriniz");
			int accountBalance = scanner.nextInt();
			if (accountBalance >= 1500) {
				account = new ShortTerm(id, accountBalance);
				account.setBalance(accountBalance);
				account.setId(id);
				list.add(account);
				registerNewUser(account);
				System.out.println("hesap oluşturuldu");

			} else {
				System.out.println("bakiyeniz yetersizdir");

			}
		}

		else if (number == 4) {
			System.out.println("câri hesap açılıyor");
			System.out.println("lütfen id giriniz");
			id = scanner.nextLine();
			System.out.println("lütfen bakiye giriniz");
			int accountBalance = scanner.nextInt();
			if (accountBalance >= 1500) {
				account = new ShortTerm(id, accountBalance);
				list.add(account);
				account.setBalance(accountBalance);
				account.setId(id);
				registerNewUser(account);
				System.out.println("hesap oluşturuldu");

			} else {
				System.out.println("bakiyeniz yetersizdir");

			}
		}

	}

	@Override
	public void withdraw() {

		String id;
		int cash;
		scanner = new Scanner(System.in);
		id = scanner.nextLine();
		scanner = new Scanner(System.in);
		cash = scanner.nextInt();

		for (Bank account : list) {
			
				int islem = account.getbalance() - cash;
				account.setBalance(islem);
				System.out.println(account.getbalance());
				System.out.println(now);
			
			
		}
	}

	@Override
	public void sortition() {
		int randomIndex = random.nextInt(list.size());
		System.out.println("kazanan " + list.get(randomIndex).getId() + " idli kullanıcımızdır");

	}

	private String id;
	private int balance;
	private String name;
	private int yearOfBalanceStart;
	private int balanceAtStart;

	public int getBalanceAtStart() {
		return balanceAtStart;
	}

	public void setBalanceAtStart(int balanceAtStart) {
		this.balanceAtStart = balanceAtStart;
	}

	public int getYearOfBalanceStart() {
		return yearOfBalanceStart;
	}

	public void setYearOfBalanceStart(int yearOfBalanceStart) {
		this.yearOfBalanceStart = yearOfBalanceStart;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;

	}

	public int getbalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter time = DateTimeFormatter.ofPattern("05-05-2023 10:40:58");
	String formattedDate = now.format(time);

}
