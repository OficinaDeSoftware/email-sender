DELETE FROM templates;

INSERT INTO
    templates
VALUES (
    gen_random_uuid(),
    $$
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Welcome Email</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f7fa;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .container {
                width: 100%;
                max-width: 600px;
                background-color: #ffffff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                text-align: center;
            }
            .header img {
                width: 50px;
                margin-bottom: 20px;
            }
            h1 {
                font-size: 24px;
                color: #333333;
                margin: 0;
            }
            p {
                color: #555555;
                font-size: 16px;
                line-height: 1.5;
            }
            .btn {
                display: inline-block;
                background-color: #3498db;
                color: #ffffff;
                padding: 12px 24px;
                border-radius: 5px;
                text-decoration: none;
                font-weight: bold;
                margin-top: 20px;
            }
            .btn:hover {
                background-color: #2980b9;
            }
            .footer {
                font-size: 14px;
                color: #888888;
                margin-top: 20px;
            }
            .footer a {
                color: #3498db;
                text-decoration: none;
            }

            .name {
                font-size: larger;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <img th:src="${logoUrl}" alt="Welcome Icon">
            </div>
            <h1>Bem-vindo!</h1>
            <p class="name" >olá <span th:text="${receiverName}">Destinatario</span>,</p>
            <p> Obrigado por participar. Estamos muito entusiasmados por ter você a bordo. </p>
            <a th:href="${loginUrl}" class="btn">ENTRAR NA SUA CONTA</a>
            <div class="footer">
                <p>Tem alguma pergunta?<br>
                    Confira nosso <a href="#"> Base de conhecimento</a> para uma resposta rápida.<br>
                <p>© 2024 <span th:text="${aplicationName}"></span>. All rights reserved.</p>
            </div>
        </div>
    </body>
    </html>
    $$,
    'register'
);