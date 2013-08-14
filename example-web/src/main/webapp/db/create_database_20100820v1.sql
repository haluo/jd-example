/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2010-8-20 15:00:15                           */
/*==============================================================*/


/*==============================================================*/
/* Table: "example_order"                                       */
/*==============================================================*/
create table "example_order"  (
   "id"                 number                          not null,
   "userId"             number,
   "orderName"          varchar(50),
   "status"             number(2),
   "created"            date,
   "modified"           date,
   constraint PK_EXAMPLE_ORDER primary key ("id")
);

/*==============================================================*/
/* Table: "example_user"                                        */
/*==============================================================*/
create table "example_user"  (
   "id"                 number                          not null,
   "userAccount"        varchar2(60),
   "userType"           number(2),
   "created"            date,
   "modified"           date,
   constraint PK_EXAMPLE_USER primary key ("id")
);


