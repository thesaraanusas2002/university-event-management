# University Event Management Website

A responsive web application designed for university event discovery and student registration. The system allows students to browse upcoming events, search and filter events, and register for selected activities.

## Project Overview

University students often receive event information through different communication channels, making it difficult to find event details and manage registrations. This project provides a centralized web interface where students can discover university events and complete registrations easily.

## Problem

Simplifies manual event discovery and registration for university students.

## Objectives

- Provide a centralized platform for university events.
- Allow students to search and filter events.
- Provide an easy-to-use event registration system.
- Validate student registration information.
- Store registration data locally for demonstration purposes.
- Provide a responsive interface for desktop and mobile devices.

## Features

- Responsive user interface
- Event dashboard
- Dynamic event cards
- Event search functionality
- Category-based event filtering
- Event details and schedules
- Student registration form
- Form validation
- Duplicate registration prevention
- Registration management
- Remove registrations
- Browser localStorage data storage
- Responsive mobile navigation

## Technologies Used

- HTML5
- CSS3
- JavaScript
- DOM Manipulation
- Browser localStorage

## Project Structure

```text
university-event-management/
├── index.html
├── events.html
├── register.html
├── README.md
├── css/
│   └── style.css
├── js/
│   ├── events.js
│   ├── main.js
│   └── register.js
└── images/
```

## How to Run

1. Download or clone this repository.
2. Open the project folder.
3. Open `index.html` in a web browser.
4. Navigate to the Events page to browse available events.
5. Use the search and category filters to find events.
6. Open the Register page to register for an event.

No server or database is required because the project uses browser localStorage for demonstration.

## Registration System

The registration form collects:

- Full Name
- Student ID
- Email
- Study Programme
- Selected Event

The system validates required fields and prevents the same student from registering for the same event more than once.

Registration information is stored using browser localStorage, allowing the data to remain available after refreshing the browser.

## Responsive Design

The website is designed to work on desktop computers, laptops, tablets, and mobile phones.

## Future Improvements

- MySQL database integration
- PHP/Node.js backend
- Student authentication
- Admin dashboard
- Email registration confirmation
- Online event attendance tracking
- Event creation and management for administrators

## Learning Outcomes

Through this project, I developed practical experience in responsive web design, HTML, CSS, JavaScript DOM manipulation, event handling, form validation, localStorage, dynamic content generation, and basic frontend application design.

## Project Status

**Completed — Academic Portfolio Project**

## Author

**Your Name**

University Student  
Information & Communication Technology
