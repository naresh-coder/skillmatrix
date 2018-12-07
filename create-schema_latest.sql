ALTER TABLE "state" DROP CONSTRAINT "fk_state";
ALTER TABLE "location" DROP CONSTRAINT "fk_location";
ALTER TABLE "address" DROP CONSTRAINT "fk_address";
ALTER TABLE "designation_matrix" DROP CONSTRAINT "fk_designation_matrix";
ALTER TABLE "designation_matrix" DROP CONSTRAINT "fk_designation_matrix_1";
ALTER TABLE "skill_matrix" DROP CONSTRAINT "fk_skill_matrix";
ALTER TABLE "skill_matrix" DROP CONSTRAINT "fk_skill_matrix_1";
ALTER TABLE "skill_matrix" DROP CONSTRAINT "fk_skill_matrix_2";
ALTER TABLE "skill_matrix" DROP CONSTRAINT "fk_skill_matrix_3";
ALTER TABLE "skill_matrix" DROP CONSTRAINT "fk_skill_matrix_4";

DROP TABLE "state";
DROP TABLE "location";
DROP TABLE "country";
DROP TABLE "employee";
DROP TABLE "address";
DROP TABLE "skill_matrix";
DROP TABLE "skill_category";
DROP TABLE "designation_type";
DROP TABLE "designation_sub_type";
DROP TABLE "designation_matrix";
DROP TABLE "skill_name";
DROP TABLE "kpi";

CREATE TABLE "state" (
  "state_id" int NOT NULL,
  "state_name" varchar(255),
  "contry_id" int,
  PRIMARY KEY ("state_id")
)
WITHOUT OIDS;
CREATE TABLE "location" (
  "location_id" int NOT NULL,
  "location_name" varchar(255),
  "state_id" int,
  "pin" varchar(255),
  PRIMARY KEY ("location_id")
)
WITHOUT OIDS;
CREATE TABLE "country" (
  "country_id" int NOT NULL,
  "contry_name" varchar(255),
  PRIMARY KEY ("country_id")
)
WITHOUT OIDS;
CREATE TABLE "employee" (
  "employee_id" int4 NOT NULL,
  "name" varchar(255),
  "email_id" int4,
  "phone_number" int4,
  "flag" varchar(255),
  "gender" varchar(255),
  "created_by" varchar(255),
  "creation_date" date,
  "updated_by" date,
  "updated_date" date,
  PRIMARY KEY ("employee_id")
)
WITHOUT OIDS;
CREATE TABLE "address" (
  "address_id" int NOT NULL,
  "address_name" varchar(255),
  "land_mark" varchar(255),
  "city" varchar(255),
  "state" varchar(255),
  "country" varchar(255),
  "employee_id" int,
  PRIMARY KEY ("address_id")
)
WITHOUT OIDS;
CREATE TABLE "skill_matrix" (
  "skill_matrix_id" int NOT NULL,
  "skill_category_id" int,
  "designation_id" int,
  "employee_id" int,
  "skill_id" int,
  "no_of_years" varchar(255),
  "isCertified" varchar(255),
  "name_of_institute" varchar(255),
  "score" varchar(255),
  "kpi_id" int,
  PRIMARY KEY ("skill_matrix_id")
)
WITHOUT OIDS;
CREATE TABLE "skill_category" (
  "id" int NOT NULL,
  "skill_category_name" varchar(255),
  PRIMARY KEY ("id")
)
WITHOUT OIDS;
CREATE TABLE "designation_type" (
  "id" int4 NOT NULL,
  "designation_name" varchar(255),
  PRIMARY KEY ("id")
)
WITHOUT OIDS;
CREATE TABLE "designation_sub_type" (
  "id" int NOT NULL,
  "sub_type_name" varchar(255),
  PRIMARY KEY ("id")
)
WITHOUT OIDS;
CREATE TABLE "designation_matrix" (
  "id" int4 NOT NULL,
  "disgnation_type_id" int4,
  "disgnation_sub_id" int4,
  PRIMARY KEY ("id")
)
WITHOUT OIDS;
CREATE TABLE "skill_name" (
  "id" int4 NOT NULL,
  "name" varchar(255),
  PRIMARY KEY ("id")
)
WITHOUT OIDS;
CREATE TABLE "kpi" (
  "id" int NOT NULL,
  "employee_target" varchar(255),
  "rechead_target" varchar(255),

  PRIMARY KEY ("id")
)
WITHOUT OIDS;

CREATE TABLE "roles" (
  "role_id" int4 NOT NULL,
  "role_name" varchar(255),
  "permisson_Id" int4,
  PRIMARY KEY ("role_id")
)
WITHOUT OIDS;
CREATE TABLE "account" (
  "id" int4 NOT NULL,
  "employee_id" int4,
  "role_id" int4,
  PRIMARY KEY ("id")
)
WITHOUT OIDS;
CREATE TABLE "permissions" (
  "id" int4 NOT NULL,
  "permissition_name" varchar(255),
  PRIMARY KEY ("id")
)
WITHOUT OIDS;

ALTER TABLE "state" ADD CONSTRAINT "fk_state" FOREIGN KEY ("contry_id") REFERENCES "country";
ALTER TABLE "location" ADD CONSTRAINT "fk_location" FOREIGN KEY ("state_id") REFERENCES "state" ;
ALTER TABLE "address" ADD CONSTRAINT "fk_address" FOREIGN KEY ("employee_id") REFERENCES "employee" ;
ALTER TABLE "designation_matrix" ADD CONSTRAINT "fk_designation_matrix" FOREIGN KEY ("disgnation_type_id" ) references  "designation_sub_type";
ALTER TABLE "designation_matrix" ADD CONSTRAINT "fk_designation_matrix_1" FOREIGN KEY ("disgnation_sub_id") REFERENCES "designation_sub_type"  ON DELETE CASCADE;
ALTER TABLE "skill_matrix" ADD CONSTRAINT "fk_skill_matrix" FOREIGN KEY ("employee_id") REFERENCES "employee" ;
ALTER TABLE "skill_matrix" ADD CONSTRAINT "fk_skill_matrix_1" FOREIGN KEY ("designation_id") REFERENCES "designation_matrix" ;
ALTER TABLE "skill_matrix" ADD CONSTRAINT "fk_skill_matrix_2" FOREIGN KEY ("skill_category_id") REFERENCES "skill_category" ;
ALTER TABLE "skill_matrix" ADD CONSTRAINT "fk_skill_matrix_3" FOREIGN KEY ("skill_id") REFERENCES "skill_name" ;
ALTER TABLE "skill_matrix" ADD CONSTRAINT "fk_skill_matrix_4" FOREIGN KEY ("kpi_id") REFERENCES "kpi" ;



ALTER TABLE "roles" ADD CONSTRAINT "fk_roles" FOREIGN KEY ("permisson_Id") REFERENCES "permissions" ();
ALTER TABLE "account" ADD CONSTRAINT "fk_account" FOREIGN KEY ("role_id") REFERENCES "roles" ();
