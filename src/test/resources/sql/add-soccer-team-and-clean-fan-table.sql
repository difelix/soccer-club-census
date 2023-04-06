DELETE FROM fan;
DELETE FROM soccer_team;

INSERT INTO soccer_team(name, foundation_date, state, fans_amount)
VALUES('Vasco da Gama', now(), 'RJ', 0);
