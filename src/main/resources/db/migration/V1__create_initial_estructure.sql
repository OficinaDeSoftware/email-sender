CREATE TABLE IF NOT EXISTS public.payload (
    id_payload UUID NOT NULL,
    nr_uuid_receiver VARCHAR(255),
    receiver VARCHAR(255),
    send_date TIMESTAMP(6) WITHOUT TIME ZONE,
    sender VARCHAR(255),
    status_email SMALLINT,
    subject VARCHAR(255),
    PRIMARY KEY (id_payload)
);

CREATE TABLE IF NOT EXISTS public.template_payload (
    contexts text,
    name VARCHAR(255),
    id_payload uuid NOT NULL,
    PRIMARY KEY (id_payload),
    FOREIGN KEY (id_payload) REFERENCES public.payload (id_payload)
);

CREATE TABLE IF NOT EXISTS public.templates (
    id_template uuid NOT NULL,
    content TEXT,
    name VARCHAR(255),
    PRIMARY KEY ( id_template )
);