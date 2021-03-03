create table categories
(
    id          integer not null auto_increment,
    name        varchar(255),
    category_id integer,
    primary key (id)
);

create table categories_products
(
    categories_id integer not null,
    products_id   integer not null
);

create table colors
(
    id   integer not null auto_increment,
    name varchar(255),
    primary key (id)
);

create table countries
(
    id   integer not null auto_increment,
    name varchar(255),
    primary key (id)
);

create table images
(
    id          integer not null auto_increment,
    name        varchar(255),
    products_id integer not null,
    primary key (id)
);

create table orders
(
    id         integer not null auto_increment,
    order_date date,
    primary key (id)
);

create table orders_products
(
    order_id    integer not null,
    products_id integer not null
);

create table personal_info
(
    id    integer not null auto_increment,
    email varchar(255),
    name  varchar(255),
    phone integer not null,
    primary key (id)
);

create table products
(
    id          integer          not null auto_increment,
    description varchar(255),
    name        varchar(255),
    price       double precision not null,
    primary key (id)
);

create table products_colors
(
    products_id integer not null,
    colors_id   integer not null
);

create table products_countries
(
    products_id  integer not null,
    countries_id integer not null
);

create table products_sizes
(
    products_id integer not null,
    sizes_id    integer not null
);

create table shipping_info
(
    id           integer not null auto_increment,
    address_line varchar(255),
    city         varchar(255),
    country      varchar(255),
    primary key (id)
);

create table shopping_cart
(
    id         integer          not null auto_increment,
    cart_total double precision not null,
    user_id    integer,
    primary key (id)
);

create table shopping_cart_products
(
    shopping_cart_id integer not null,
    products_id      integer not null
);

create table sizes
(
    id   integer not null auto_increment,
    name varchar(255),
    primary key (id)
);

create table users
(
    id               integer not null auto_increment,
    active           bit     not null,
    email            varchar(255),
    password         varchar(255),
    token            varchar(255),
    user_type        varchar(255),
    username         varchar(255),
    order_id         integer,
    personal_info_id integer,
    shipping_info_id integer,
    shopping_cart_id integer,
    primary key (id)
);

alter table orders_products
    add constraint UK_qmviv5y7625wak8tjq4nirybh unique (products_id);
alter table categories
    add constraint FK1e7hbubpwyuq2199b8jrx42h8 foreign key (category_id) references categories (id);
alter table categories_products
    add constraint FKad19ea8ca86lh5f3wmgg83vmj foreign key (products_id) references products (id);
alter table categories_products
    add constraint FK86b8j2u9mcr7a46vgtxyo8xwx foreign key (categories_id) references categories (id);
alter table images
    add constraint FK7a96p9ncl6hbkh5abxt2xndb5 foreign key (products_id) references products (id);
alter table orders_products
    add constraint FKqgxvu9mvqx0bv2ew776laoqvv foreign key (products_id) references products (id);
alter table orders_products
    add constraint FKe4y1sseio787e4o5hrml7omt5 foreign key (order_id) references orders (id);
alter table products_colors
    add constraint FKhnq3sslcacfhlkvr87jd85383 foreign key (colors_id) references colors (id);
alter table products_colors
    add constraint FK9nfsxpqpfmofw5eu5hvp46m9m foreign key (products_id) references products (id);
alter table products_countries
    add constraint FK2bgy988vcbvqhq8vgoxbj1ojl foreign key (countries_id) references countries (id);
alter table products_countries
    add constraint FKobn9pfho6617jjhrg1tuy0np8 foreign key (products_id) references products (id);
alter table products_sizes
    add constraint FK5kmjbhgswv2c17la0fdxavxxj foreign key (sizes_id) references sizes (id);
alter table products_sizes
    add constraint FKmdr58ukqmem0vurfsyq4gv85o foreign key (products_id) references products (id);
alter table shopping_cart
    add constraint FKr1irjigmqcpfrvggavnr7vjyv foreign key (user_id) references users (id);
alter table shopping_cart_products
    add constraint FK30072utx7e45nste37w5qbcec foreign key (products_id) references products (id);
alter table shopping_cart_products
    add constraint FKb0wl9vd38umuh226jsjqx3grq foreign key (shopping_cart_id) references shopping_cart (id);
alter table users
    add constraint FK58jef2oi0dogn5n6chm0cvmnl foreign key (order_id) references orders (id);
alter table users
    add constraint FK3gv2nmhlal71u42s59b0ruwjl foreign key (personal_info_id) references personal_info (id);
alter table users
    add constraint FKe1793m17i95r5s91oy284kr4p foreign key (shipping_info_id) references shipping_info (id);
alter table users
    add constraint FKg9bdq6h4q87ner8a59wsiq39d foreign key (shopping_cart_id) references shopping_cart (id)