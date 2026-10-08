# C-Projects
My C++ practice projects. Simple Projects I made while learning C++.

| ATM System | Simple console ATM with PIN login, deposit, withdra

# ATM System (C++)

A simple console ATM program written in C++. It uses only variables, functions, loops, and if/switch statements. There is no OOP and no data structures.

## Features
- Login with a PIN (3 attempts allowed)
- Check balance
- Deposit money
- Withdraw money
- Change PIN
- Handles wrong input safely

## Default Details
- PIN: `1234`
- Starting balance: `5000`

## How to Run

Compile the program:
```bash
g++ atm_system.cpp -o atm
```

Run the program:
```bash
./atm
```

On Windows, run it with:
```bash
atm.exe
```

## Sample Output
```
===== WELCOME TO THE ATM =====
Enter your PIN: 1234

===== ATM MENU =====
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Change PIN
5. Exit
Choose an option: 1
Your current balance is: 5000.00
```

## What I Practiced
- Functions
- Loops (`while`, `do-while`)
- Conditions (`if`, `else`, `switch`)
- Passing values by reference
- Checking user input

## License
MIT