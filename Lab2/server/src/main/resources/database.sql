PGDMP     8            	        y           db    13.2    13.2     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    24716    db    DATABASE     f   CREATE DATABASE db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1251';
    DROP DATABASE db;
                postgres    false            ?            1259    24717    category    TABLE     y   CREATE TABLE public.category (
    category_number integer NOT NULL,
    category_name character varying(50) NOT NULL
);
    DROP TABLE public.category;
       public         heap    postgres    false            ?            1259    24742    check    TABLE       CREATE TABLE public."check" (
    check_number character varying(10) NOT NULL,
    id_employee character varying(10) NOT NULL,
    card_number character varying(13),
    print_date date NOT NULL,
    sum_total numeric(13,4) NOT NULL,
    vat numeric(13,4) NOT NULL
);
    DROP TABLE public."check";
       public         heap    postgres    false            ?            1259    24737    customer_card    TABLE     ?  CREATE TABLE public.customer_card (
    card_number character varying(13) NOT NULL,
    cust_name character varying(50) NOT NULL,
    cust_surname character varying(50) NOT NULL,
    cust_patronymic character varying(50) NOT NULL,
    phone_number character varying(13) NOT NULL,
    city character varying(50),
    street character varying(50),
    zip_code character varying(9),
    percent integer NOT NULL
);
 !   DROP TABLE public.customer_card;
       public         heap    postgres    false            ?            1259    24732    employee    TABLE     #  CREATE TABLE public.employee (
    id_employee character varying(10) NOT NULL,
    empl_surname character varying(50) NOT NULL,
    empl_name character varying(50) NOT NULL,
    empl_patronymic character varying(50) NOT NULL,
    role character varying(10) NOT NULL,
    salary numeric(13,4) NOT NULL,
    date_of_birth date NOT NULL,
    date_of_start date NOT NULL,
    phone_number character varying(13) NOT NULL,
    city character varying(50) NOT NULL,
    street character varying(50) NOT NULL,
    zip_code character varying(9) NOT NULL
);
    DROP TABLE public.employee;
       public         heap    postgres    false            ?            1259    24722    product    TABLE     ?   CREATE TABLE public.product (
    id_product integer NOT NULL,
    category_number integer NOT NULL,
    product_name character varying(50) NOT NULL,
    characteristics character varying(100) NOT NULL
);
    DROP TABLE public.product;
       public         heap    postgres    false            ?            1259    24784    sale    TABLE     ?   CREATE TABLE public.sale (
    upc character varying(12) NOT NULL,
    check_number character varying(10) NOT NULL,
    product_number integer NOT NULL,
    selling_price numeric(13,4) NOT NULL
);
    DROP TABLE public.sale;
       public         heap    postgres    false            ?            1259    24757    store_product    TABLE       CREATE TABLE public.store_product (
    upc character varying(12) NOT NULL,
    upc_prom character varying(12),
    id_product integer NOT NULL,
    selling_price numeric(13,4) NOT NULL,
    products_number integer NOT NULL,
    promotional_product boolean NOT NULL
);
 !   DROP TABLE public.store_product;
       public         heap    postgres    false            ?           2606    24741    customer_card card_number_pk 
   CONSTRAINT     c   ALTER TABLE ONLY public.customer_card
    ADD CONSTRAINT card_number_pk PRIMARY KEY (card_number);
 F   ALTER TABLE ONLY public.customer_card DROP CONSTRAINT card_number_pk;
       public            postgres    false    203            9           2606    24721    category category_number_pk 
   CONSTRAINT     f   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_number_pk PRIMARY KEY (category_number);
 E   ALTER TABLE ONLY public.category DROP CONSTRAINT category_number_pk;
       public            postgres    false    200            A           2606    24746    check check_number_fk 
   CONSTRAINT     _   ALTER TABLE ONLY public."check"
    ADD CONSTRAINT check_number_fk PRIMARY KEY (check_number);
 A   ALTER TABLE ONLY public."check" DROP CONSTRAINT check_number_fk;
       public            postgres    false    204            =           2606    24736    employee id_employee_pk 
   CONSTRAINT     ^   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT id_employee_pk PRIMARY KEY (id_employee);
 A   ALTER TABLE ONLY public.employee DROP CONSTRAINT id_employee_pk;
       public            postgres    false    202            ;           2606    24726    product id_product_pk 
   CONSTRAINT     [   ALTER TABLE ONLY public.product
    ADD CONSTRAINT id_product_pk PRIMARY KEY (id_product);
 ?   ALTER TABLE ONLY public.product DROP CONSTRAINT id_product_pk;
       public            postgres    false    201            E           2606    24788    sale sale_pk 
   CONSTRAINT     Y   ALTER TABLE ONLY public.sale
    ADD CONSTRAINT sale_pk PRIMARY KEY (upc, check_number);
 6   ALTER TABLE ONLY public.sale DROP CONSTRAINT sale_pk;
       public            postgres    false    206    206            C           2606    24773    store_product store_product_pk 
   CONSTRAINT     ]   ALTER TABLE ONLY public.store_product
    ADD CONSTRAINT store_product_pk PRIMARY KEY (upc);
 H   ALTER TABLE ONLY public.store_product DROP CONSTRAINT store_product_pk;
       public            postgres    false    205            H           2606    24752    check card_number_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public."check"
    ADD CONSTRAINT card_number_fk FOREIGN KEY (card_number) REFERENCES public.customer_card(card_number) ON UPDATE CASCADE;
 @   ALTER TABLE ONLY public."check" DROP CONSTRAINT card_number_fk;
       public          postgres    false    203    2879    204            F           2606    24727    product category_name_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.product
    ADD CONSTRAINT category_name_fk FOREIGN KEY (category_number) REFERENCES public.category(category_number) ON UPDATE CASCADE;
 B   ALTER TABLE ONLY public.product DROP CONSTRAINT category_name_fk;
       public          postgres    false    201    2873    200            L           2606    24794    sale check_number_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.sale
    ADD CONSTRAINT check_number_fk FOREIGN KEY (check_number) REFERENCES public."check"(check_number) ON UPDATE CASCADE ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.sale DROP CONSTRAINT check_number_fk;
       public          postgres    false    206    2881    204            G           2606    24747    check id_employee_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public."check"
    ADD CONSTRAINT id_employee_fk FOREIGN KEY (id_employee) REFERENCES public.employee(id_employee) ON UPDATE CASCADE;
 @   ALTER TABLE ONLY public."check" DROP CONSTRAINT id_employee_fk;
       public          postgres    false    202    204    2877            I           2606    24779    store_product id_product_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.store_product
    ADD CONSTRAINT id_product_fk FOREIGN KEY (id_product) REFERENCES public.product(id_product) ON UPDATE CASCADE;
 E   ALTER TABLE ONLY public.store_product DROP CONSTRAINT id_product_fk;
       public          postgres    false    2875    201    205            K           2606    24789    sale upc_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.sale
    ADD CONSTRAINT upc_fk FOREIGN KEY (upc) REFERENCES public.store_product(upc) ON UPDATE CASCADE;
 5   ALTER TABLE ONLY public.sale DROP CONSTRAINT upc_fk;
       public          postgres    false    2883    206    205            J           2606    24774    store_product upc_prom_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.store_product
    ADD CONSTRAINT upc_prom_fk FOREIGN KEY (upc_prom) REFERENCES public.store_product(upc) ON UPDATE CASCADE ON DELETE SET NULL;
 C   ALTER TABLE ONLY public.store_product DROP CONSTRAINT upc_prom_fk;
       public          postgres    false    2883    205    205           