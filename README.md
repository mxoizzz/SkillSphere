<!-- SkillSphere README.md -->
<h1 align="center">💼 SkillSphere — Smart Skill Development & Career Recommendation System</h1>

<p align="center">
  <b>Empowering learners with AI-driven skill growth, personalized career paths, and real-world project opportunities.</b>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-Swing-orange?logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/MySQL-Database-blue?logo=mysql&logoColor=white" />
  <img src="https://img.shields.io/badge/JDBC-Backend-yellow" />
  <img src="https://img.shields.io/badge/PDF-iText/PDFBox-green" />
  <img src="https://img.shields.io/badge/AI-Gemini/OpenAI-purple" />
  <img src="https://img.shields.io/badge/License-MIT-lightgrey" />
</p>

---

## 🌟 Overview

**SkillSphere** is a desktop-based, AI-powered learning and career guidance system built using **Java Swing** and **MySQL**.  
It helps learners build new skills, generate resumes, find projects, and receive personalized career recommendations powered by **AI**.

---

## 🚀 Features at a Glance

<details>
<summary>👥 User Management</summary>

- Role-based login & registration (Learner, Mentor, Employer, Admin)  
- Profile management with secure password hashing  
- User-friendly dashboards for each role  

</details>

<details>
<summary>📚 Course Management</summary>

- Mentors/Admins can create & manage courses  
- Learners can enroll and track progress  
- Auto-generate **course completion certificates (PDF)**  

</details>

<details>
<summary>🧾 Portfolio & Resume Builder</summary>

- Build and manage digital portfolios  
- Generate professional **resumes in PDF** format  
- Get **AI-powered resume improvement suggestions**  

</details>

<details>
<summary>💼 Project Marketplace</summary>

- Employers post projects with budgets  
- Learners & mentors can apply or bid  
- Track project applications and statuses  

</details>

<details>
<summary>🤖 AI Career Assistant</summary>

- Personalized skill & course recommendations  
- AI-generated cover letters  
- Resume feedback and improvement suggestions  
- Powered by **Gemini/OpenAI API**  

</details>

<details>
<summary>📊 Admin Dashboard</summary>

- Manage users, courses, and projects  
- Analytics & charts using **JFreeChart**  
- Export reports in PDF format  

</details>

---

## ⚙️ Tech Stack

| Layer | Technology | Purpose |
|-------|-------------|----------|
| **Frontend (UI)** | Java Swing | Desktop GUI |
| **Backend / Logic** | Core Java + JDBC | Business logic |
| **Database** | MySQL | Persistent data storage |
| **AI Integration** | OpenAI / Gemini API | AI-driven insights |
| **PDF Generation** | iText / Apache PDFBox | Resume & certificate creation |
| **Charts & Analytics** | JFreeChart | Admin insights |
| **Libraries** | Gson, JBCrypt | JSON parsing & password hashing |

---

## 🧩 Project Structure

SkillSphere/
<br>
│
<br>
├── src/
<br>
│ ├── dao/ # Database access (JDBC)
<br>
│ ├── model/ # JavaBeans (Entities)
<br>
│ ├── service/ # Business logic
<br>
│ ├── ui/ # Swing GUI forms
<br>
│ ├── utils/ # Helpers (PDF, charts, password, validation)
<br>
│ └── main/ # Main app launcher
<br>
│
<br>
├── lib/ # External JAR libraries
<br>
├── assets/ # Icons, PDFs, images
<br>
├── database/ # SQL schema & test data
<br>
└── README.md
yaml
Copy code

---

## 🛠️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/<your-username>/SkillSphere-JavaSwing.git
cd SkillSphere-JavaSwing
```
### 2️⃣ Add Dependencies
Place the following JARs inside the lib/ folder:
<ul>
  
<li>jbcrypt-0.4.jar</li>
<li>itextpdf-5.x.x.jar or pdfbox.jar</li>
<li>mysql-connector-java-8.xx.jar</li>
<li>jfreechart-x.x.x.jar</li>
<li>gson-x.x.x.jar</li>
</ul>

### 3️⃣ Import the Database
Open MySQL and run:
```bash
SOURCE database/schema.sql;
```
### 4️⃣ Run the App
Open src/main/SkillSphereApp.java → Right-click → Run Java

💡 Make sure your VS Code or IntelliJ project settings include:
```bash
"java.project.referencedLibraries": ["lib/**/*.jar"]
```
<hr>
🧑‍💻 Developer <br>
Moiz Shaikh <br>
Full Stack Developer | Java • Spring Boot • React • MySQL<br>
📧 moiz.shaikh32477@gmail.com<br>
🌐 <a href="https://github.com/mxoizzz/">mxoizzz</a>

### 🔮 Future Enhancements
<ul>
<li>💬 Real-time chat using Java Sockets</li>
<li>☁️ Cloud backup for user data</li>
<li>📱 Mobile version (Flutter)</li>
<li>💳 Payment gateway for course enrollments</li>
</ul>

<p align="center"> ⭐ If you like this project, give it a star on <a href="https://github.com/mxoizzz/SkillSphere-JavaSwing">GitHub</a>! </p> 
