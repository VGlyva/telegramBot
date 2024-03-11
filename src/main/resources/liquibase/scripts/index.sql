-- liquibase formatted sql

-- changeset vglyva:1
create table notification_task (
    id bigserial primary key,
    chad_id bigint not null,
    message_text VARCHAR(255) not null,
    time_and_date TIMESTAMP not null
);
