ALTER TABLE todos
ALTER COLUMN id DROP DEFAULT,
ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY;