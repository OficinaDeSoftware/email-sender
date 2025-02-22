# Email Sender

A e-mail sender, send custom e-mail base on html templates.

- For migrations, the [Flyway]( https://documentation.red-gate.com/fd/getting-started-with-flyway-184127223.html) is used 
- For templates, the [Thymeleaf]( https://docs.spring.io/spring-framework/reference/web/webmvc-view/mvc-thymeleaf.html ) is used 

- For send e-mails is necessary a [APP Password](  https://support.google.com/accounts/answer/185833 )

### Now suport two templates

 ![Welcome]( documentation/images/welcome.png)

 ![Event Finished]( documentation/images/event_finished.png )

### Environment Variables

| Environment Variable | Description | Example |
|----------------------|-------------|---------|
| `DB_URL` | Base URL of database | `jdbc:postgresql://localhost:5432/email-sender` |
| `DB_USERNAME` | Username of database | `postgres` |
| `DB_PASSWORD` | Password of database | `postgres` |
| `RABITMQ_ADDRESS` | URL of the RabbitMQ servers that the Spring application should connect to | `amqps://12323:sdgasjhdgshgdg@cow.rmq2.cloudamqp.com/12323` |
| `BROKER_EMAIL` | Base URL of database | `jdbc:postgresql://localhost:5432/email-sender` |
| `MAIL_USERNAME` | E-mail that is sender of emails | `test@gmail.com` |
| `MAIL_PASSWORD` | Password of authentication of sender e-mail | `1233 1234 3242 3453` |
