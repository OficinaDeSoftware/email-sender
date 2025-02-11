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
    </head>
    <body style="font-family: Arial, sans-serif; background-color: #ececec; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; width: 100%;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td align="center">
                    <div style="width: 600px; height: 355px; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); text-align: center;">
                        <div style="margin-bottom: 10px;">
                            <img th:src="${logoUrl}" alt="Welcome Icon" style="width: 50px;">
                        </div>
                        <h1 style="font-size: 24px; color: #333333; margin: 0;">Bem-vindo!</h1>
                        <p class="name" style="font-size: larger;">Olá <span th:text="${receiverName}">Destinatario</span>,</p>
                        <p style="color: #555555; font-size: 16px; line-height: 1.5;">Seu cadastro foi realizado com sucesso. <br> Estamos muito entusiasmados por ter você a bordo.</p>
                        <a th:href="${loginUrl}" style="display: inline-block; background-color: #3498db; color: #ffffff; padding: 12px 24px; border-radius: 5px; text-decoration: none; font-weight: bold; margin-top: 5px;">ENTRAR NA SUA CONTA</a>
                        <div style="font-size: 14px; color: #888888; margin-top: 10px;">
                            <p>Tem alguma pergunta?<br>
                                Confira nosso <a href="#" style="color: #3498db; text-decoration: none;">Base de conhecimento</a> para uma resposta rápida.<br>
                            </p>
                            <p>© 2024 <span th:text="${aplicationName}"></span>. All rights reserved.</p>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </body>
    </html>
    $$,
    'register'
);

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
        <title>Conclusion E-mail</title>
    </head>
    <body style="font-family: Arial, sans-serif; background-color: #ececec; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; width: 100%;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td align="center">
                <div style="width: 600px; height: 355px; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); text-align: center;">
                    <div style="margin-bottom: 10px;">
                    <img th:src="${logoUrl}" alt="Welcome Icon" style="width: 50px;">
                </div>
                <h1 style="font-size: 24px; color: #333333; margin: 0;">Parabéns!</h1>
                <p class="name" style="font-size: larger;">Olá <span th:text="${receiverName}">Destinatario</span>,</p>
                <p style="color: #555555; font-size: 16px; line-height: 1.5;"> É com grande satisfação que enviamos o seu certificado de <label th:text="${nameEvent}">Event name</label>. Seu esforço e dedicação foram fundamentais para essa realização, e esperamos que essa conquista seja um grande passo na sua trajetória profissional.</p>
                    <p style="color: #555555; font-size: 16px; line-height: 1.5;">📜 Você pode acessar o seu certificado através do link abaixo: <a th:href="${certificadoUrl}" style="color: #3498db; text-decoration: none;">certificados</a></p>
                        <div style="font-size: 14px; color: #888888; margin-top: 10px;">
                            <p>Tem alguma pergunta?<br>
                                Confira nosso <a href="#" style="color: #3498db; text-decoration: none;">Base de conhecimento</a> para uma resposta rápida.<br>
                            </p>
                            <p>© 2024 <span th:text="${aplicationName}"></span>. All rights reserved.</p>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </body>
    </html>
    $$,
    'conclusion'
);

