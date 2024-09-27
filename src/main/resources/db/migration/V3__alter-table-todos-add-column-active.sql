ALTER TABLE todos ADD COLUMN active BOOLEAN;
UPDATE todos SET active = true;