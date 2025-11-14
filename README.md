# NYC Halal Cart Application

---

## Table of Contents

- [Overview](#overview)
- [Application Screens](#application-screens)
- [Interesting Code Example](#interesting-code-example)
- [Author](#author)

---

## 📘 Project Overview
This project is a Java Swing–based point-of-sale (POS) application inspired by a real NYC Halal food cart.
It allows customers to build custom halal meals by selecting plates, toppings, sides, and drinks.
Once the order is complete, the application automatically:
	•	Calculates the total price
	•	Generates a receipt file
	•	Emails the receipt to the customer
	•	Logs receipt data and email information securely into separate CSV files

The GUI is designed to be simple, clean, and customer-friendly — with no administrative access or exposure of other customers’ information.
All the customer must provide is their email address, and the system handles the rest.

The application uses Jakarta Mail to send confirmation emails and Java I/O to handle receipt creation and data logging.
This project demonstrates how Swing can be used to build a fully functioning, real-world ordering and receipt-delivery system.


---

## 🖼️ Application Screens
The GUI portion of the project is built using **Java Swing**, providing a simple and intuitive interface for interaction.  
Users can perform various tasks depending on the scenario (for example, creating or managing entities in a similar system).
Example screens:



<img width="593" height="497" alt="Screenshot 2025-11-13 at 9 14 36 PM" src="https://github.com/user-attachments/assets/2bf547c0-fd55-4824-af45-3e8dae2ee413" />
<img width="591" height="490" alt="Screenshot 2025-11-13 at 4 14 18 PM" src="https://github.com/user-attachments/assets/8f42c4e0-ce3e-4b0c-9eb1-79fbd528d24b" />
<img width="600" height="498" alt="Screenshot 2025-11-13 at 4 14 11 PM" src="https://github.com/user-attachments/assets/9462c8a8-72db-485d-8b5f-c92a42feda9e" />
<img width="595" height="496" alt="Screenshot 2025-11-13 at 4 13 54 PM" src="https://github.com/user-attachments/assets/034f1f02-0f52-4b21-9f20-c6a136fb5a30" />
<img width="598" height="497" alt="Screenshot 2025-11-13 at 4 13 45 PM" src="https://github.com/user-attachments/assets/4c65cd87-b0a4-4570-b680-93cae1a8dda6" />
<img width="593" height="493" alt="Screenshot 2025-11-13 at 4 13 35 PM" src="https://github.com/user-attachments/assets/1b3b592b-e9a8-4afe-9b71-f479cd645ade" />
<img width="595" height="495" alt="Screenshot 2025-11-13 at 4 13 02 PM" src="https://github.com/user-attachments/assets/ccd38de5-40d7-43fb-97d2-7819871caeae" />



---

## 💡 Interesting Code Example
One of the most interesting parts of this project to me was adding a feature to send automated emails to customers. In classes like **EmailSender** and **PrivateDataLogger**, I was able to configure the gmail SMTP to send emails and store customer receipts with their info attached. 
<img width="815" height="512" alt="Screenshot 2025-11-13 at 6 23 22 PM" src="https://github.com/user-attachments/assets/b11769d1-e45b-4d82-9d5a-70b8776eef76" />
<img width="809" height="184" alt="Screenshot 2025-11-13 at 6 22 34 PM" src="https://github.com/user-attachments/assets/ece84b94-33b2-4177-9bc3-8315889b55bb" />

---

## Author

**Developed by:** Ahmad Kourouma  
**Academy:** Year Up United  
**Capstone Project:** Capstone 2 — NYC Halal Cart Application 
**GitHub:** [https://github.com/akgit00](https://github.com/akgit00)

