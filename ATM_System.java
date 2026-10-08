
Atm system · CPP
// Simple ATM System in C++
// Uses only variables, functions, loops, and if/switch (no OOP, no data structures)
 
#include <iostream>
#include <iomanip>
#include <limits>
using namespace std;
 
void showMenu() {
    cout << "\n===== ATM MENU =====\n";
    cout << "1. Check Balance\n";
    cout << "2. Deposit Money\n";
    cout << "3. Withdraw Money\n";
    cout << "4. Change PIN\n";
    cout << "5. Exit\n";
    cout << "Choose an option: ";
}
 
void checkBalance(double balance) {
    cout << fixed << setprecision(2);
    cout << "Your current balance is: " << balance << endl;
}
 
void deposit(double &balance) {
    double amount;
    cout << "Enter amount to deposit: ";
    cin >> amount;
 
    if (cin.fail() || amount <= 0) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Invalid amount.\n";
    } else {
        balance += amount;
        cout << "Deposit successful.\n";
        checkBalance(balance);
    }
}
 
void withdraw(double &balance) {
    double amount;
    cout << "Enter amount to withdraw: ";
    cin >> amount;
 
    if (cin.fail() || amount <= 0) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Invalid amount.\n";
    } else if (amount > balance) {
        cout << "Insufficient balance.\n";
    } else {
        balance -= amount;
        cout << "Please take your cash.\n";
        checkBalance(balance);
    }
}
 
void changePin(int &pin) {
    int oldPin, newPin;
    cout << "Enter current PIN: ";
    cin >> oldPin;
 
    if (cin.fail()) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Invalid input.\n";
    } else if (oldPin != pin) {
        cout << "Wrong PIN.\n";
    } else {
        cout << "Enter new 4-digit PIN: ";
        cin >> newPin;
        if (cin.fail() || newPin < 1000 || newPin > 9999) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "PIN must be 4 digits.\n";
        } else {
            pin = newPin;
            cout << "PIN changed successfully.\n";
        }
    }
}
 
int main() {
    int pin = 1234;          // default PIN
    double balance = 5000;   // starting balance
    int enteredPin;
    int attempts = 0;
    bool loggedIn = false;
 
    cout << "===== WELCOME TO THE ATM =====\n";
 
    // Login: 3 attempts allowed
    while (attempts < 3) {
        cout << "Enter your PIN: ";
        cin >> enteredPin;
 
        if (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            enteredPin = -1;
        }
 
        if (enteredPin == pin) {
            loggedIn = true;
            break;
        }
        attempts++;
        cout << "Wrong PIN. Attempts left: " << 3 - attempts << endl;
    }
 
    if (!loggedIn) {
        cout << "Card blocked. Please contact your bank.\n";
        return 0;
    }
 
    int choice;
    do {
        showMenu();
        cin >> choice;
 
        if (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            choice = 0;
        }
 
        switch (choice) {
            case 1: checkBalance(balance); break;
            case 2: deposit(balance); break;
            case 3: withdraw(balance); break;
            case 4: changePin(pin); break;
            case 5: cout << "Thank you for using our ATM. Goodbye!\n"; break;
            default: cout << "Invalid option. Try again.\n";
        }
    } while (choice != 5);
 
    return 0;
}
 

