package BankSystem;

public interface IAccount {
	void getBalance(Bank person);

    void getID(Bank person);

    void benefit(Bank person);

    // bu kısma bankın kendi methodları yazılmıştır

    void getAccounts();

    void getDate();

    void deposit();

    void withdraw();

    void sortition();

    void registerNewUser(Bank person);

    void transaction();

    void createNewAccount(int number);

    void showIDs();
}
