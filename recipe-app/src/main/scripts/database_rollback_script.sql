#roll back script
drop table ingredient;
drop table recipe_category;
drop table unit_of_measure;
drop table category;
alter table recipe drop foreign key FK37al6kcbdasgfnut9xokktie9;
alter table notes drop foreign key FKdbfsiv21ocsbt63sd6fg0t3c8;
drop table recipe;
drop table notes;