# Eight B-B
Java Project for the Course Programmazione 3 e Laboratorio di Programmazione 3 from the Computer Science Graduation from University Parthenope Napoli

# Index
- [about](#About)
- [Tecnolgies Used](#Tecnolgies-Used)
- [Software Used](#Software-Used)
- [Disclamer](#Disclamer)


# About
Progretto Java sulla base del Progetto di "Ingegneria dell'Software e Interazione Uomo-Macchina' - Traccia B&B.
Il nostro progetto si basa su una piattaforma Java distribuita tra Client e Server.

# Tecnologies Used
## Programmi:
- IntelliJ
- MySQL WorkBench
## Pattern Utilizzati:
- Abstract Factory
- Factory
- Chain of Responsability
- Strategy
- Memento
- Visitor
- Template
- Adapter
- Proxy
- Facade

## Database Usato:
MySQL Community Server 8.0

# Disclamer:
Si notifica che, per il corretto funzionamento del progetto, é necessario un collegamento ad un Database MySQL 8.0.

Istruzioni per il collegamento:
1. Installare l'ultima versione del server MySQL Community Edition.
2. Importare nel DB il Dump Presente nel Zip Col nome "DumpDB".
3. Modificare Lato Server la classe "DatabaseProxy",presente presso: it.EightBB.Server/Database, i seguenti valori:
- url, modificare localhost con il vostro ip o url del Server MySqL.
- user 'nel caso si sia modificato il root'.
- pass con la password del root 
4. nel caso dia errore Lato Server Per mancanza di driver, si prega di implementare i driver "MySQL Connector Java 8.0'
