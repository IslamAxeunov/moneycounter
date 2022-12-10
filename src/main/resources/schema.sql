CREATE TABLE IF NOT EXISTS money_counter (
    id IDENTITY NOT NULL,
    description VARCHAR(50),
    money NUMERIC NOT NULL,
    local_time TIMESTAMP
    );
