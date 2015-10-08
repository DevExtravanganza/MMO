--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.4
-- Started on 2015-10-08 16:07:40

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 177 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2039 (class 0 OID 0)
-- Dependencies: 177
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 172 (class 1259 OID 16439)
-- Name: characters; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE characters (
    name character varying NOT NULL,
    class character varying,
    race character varying,
    level integer
);


ALTER TABLE characters OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16448)
-- Name: owns; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE owns (
    character_name character varying NOT NULL,
    user_name character varying NOT NULL
);


ALTER TABLE owns OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 16445)
-- Name: servers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE servers (
    address character varying NOT NULL,
    name character varying,
    location character varying,
    max_users integer,
    connected_users integer
);


ALTER TABLE servers OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 16451)
-- Name: stores; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE stores (
    server_address character varying NOT NULL,
    user_name character varying NOT NULL
);


ALTER TABLE stores OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16442)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    user_name character varying NOT NULL,
    balance integer DEFAULT 0.00 NOT NULL,
    first_name character varying,
    last_name character varying,
    iban character varying,
    character_slots integer DEFAULT 0,
    last_payment date,
    months_paid integer DEFAULT 0 NOT NULL,
    password character varying,
    banned boolean DEFAULT false
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 2027 (class 0 OID 16439)
-- Dependencies: 172
-- Data for Name: characters; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY characters (name, class, race, level) FROM stdin;
Character name	Slave	Orc	41
Characterhbh	Slave	Orc	77
Characterwsda	Slave	Orc	99
Bobby	Sorcerer	Troll	74
\.


--
-- TOC entry 2030 (class 0 OID 16448)
-- Dependencies: 175
-- Data for Name: owns; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY owns (character_name, user_name) FROM stdin;
Characterhbh	username
Characterwsda	username
Bobby	username
\.


--
-- TOC entry 2029 (class 0 OID 16445)
-- Dependencies: 174
-- Data for Name: servers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY servers (address, name, location, max_users, connected_users) FROM stdin;
\.


--
-- TOC entry 2031 (class 0 OID 16451)
-- Dependencies: 176
-- Data for Name: stores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY stores (server_address, user_name) FROM stdin;
\.


--
-- TOC entry 2028 (class 0 OID 16442)
-- Dependencies: 173
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (user_name, balance, first_name, last_name, iban, character_slots, last_payment, months_paid, password, banned) FROM stdin;
username	4468	first name	last name	iban	55	2015-10-08	3552	password	\N
\.


--
-- TOC entry 1905 (class 2606 OID 16458)
-- Name: characters_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY characters
    ADD CONSTRAINT characters_pkey PRIMARY KEY (name);


--
-- TOC entry 1911 (class 2606 OID 16496)
-- Name: owns_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY owns
    ADD CONSTRAINT owns_pkey PRIMARY KEY (character_name, user_name);


--
-- TOC entry 1909 (class 2606 OID 16468)
-- Name: servers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY servers
    ADD CONSTRAINT servers_pkey PRIMARY KEY (address);


--
-- TOC entry 1913 (class 2606 OID 16498)
-- Name: stores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY stores
    ADD CONSTRAINT stores_pkey PRIMARY KEY (server_address, user_name);


--
-- TOC entry 1907 (class 2606 OID 16463)
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_name);


--
-- TOC entry 1914 (class 2606 OID 16485)
-- Name: owns_character_name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY owns
    ADD CONSTRAINT owns_character_name_fkey FOREIGN KEY (character_name) REFERENCES characters(name);


--
-- TOC entry 1915 (class 2606 OID 16490)
-- Name: owns_user_name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY owns
    ADD CONSTRAINT owns_user_name_fkey FOREIGN KEY (user_name) REFERENCES users(user_name);


--
-- TOC entry 1916 (class 2606 OID 16472)
-- Name: stores_server_address_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stores
    ADD CONSTRAINT stores_server_address_fkey FOREIGN KEY (server_address) REFERENCES servers(address);


--
-- TOC entry 1917 (class 2606 OID 16477)
-- Name: stores_user_name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stores
    ADD CONSTRAINT stores_user_name_fkey FOREIGN KEY (user_name) REFERENCES users(user_name);


--
-- TOC entry 2038 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-10-08 16:07:40

--
-- PostgreSQL database dump complete
--

