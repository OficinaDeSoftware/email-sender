# Email Sender

A e-mail sender, send custom e-mail base on html templates.

### Environment Variables

- `DB_URL`
    - <b>Description:</b> Base url of database
    - <b>Example:</b> jdbc:postgresql://localhost:5432/email-sender
- `DB_USERNAME`
    - <b>Description:</b> Username of database
    - <b>Example:</b> postgres
- `DB_PASSWORD`
    - <b>Description:</b> Password of database
    - <b>Example:</b> postgres
- `RABITMQ_ADDRESS`
    - <b>Description:</b> URL of the RabbitMQ servers that the Spring application should connect to
    - <b>Example:</b> amqps://12323:sdgasjhdgshgdg@cow.rmq2.cloudamqp.com/12323
- `BROKER_EMAIL`
    - <b>Description:</b> Base url of database
    - <b>Example:</b> jdbc:postgresql://localhost:5432/email-sender
- `MAIL_USERNAME`
    - <b>Description:</b> E-mail that is sender of emails
    - <b>Example:</b> test@gmail.com
- `MAIL_PASSWORD`
    - <b>Description:</b> Password of authentication of sender e-mail.
    - <b>Example:</b> 1233 1234 3242 3453
