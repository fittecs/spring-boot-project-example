BEGIN;
DELETE FROM developer WHERE id = 1;
INSERT INTO developer VALUES (1, 'developer1');
COMMIT;