CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE notes (
       id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
       title TEXT NOT NULL,
       content TEXT NOT NULL,
       created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
       updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);