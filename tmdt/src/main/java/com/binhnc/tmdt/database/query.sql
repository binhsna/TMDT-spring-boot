
select * from categories;

/*insert into categories values
(N'Áo',1),
(N'Quần',0)*/
-- drop table products;
go
select * from categories c where c.category_name like '%Q%';
go
select * from categories;
go
select * from products;
go
exec sp_help products;
go