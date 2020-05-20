--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: cursos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.cursos (
    id_cursos integer NOT NULL,
    nombre character varying,
    id_usuarios integer,
    escolaridad character varying,
    grado integer,
    periodo date,
    grupo character varying(255),
    examen character varying(255),
    tarea character varying(255)
);


--
-- Name: cursos_id_cursos_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.cursos_id_cursos_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: cursos_id_cursos_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.cursos_id_cursos_seq OWNED BY public.cursos.id_cursos;


--
-- Name: escuelas; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.escuelas (
    id_esc integer NOT NULL,
    id_sep character varying NOT NULL,
    nombre character varying NOT NULL
);


--
-- Name: escuelas_id_esc_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.escuelas_id_esc_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: escuelas_id_esc_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.escuelas_id_esc_seq OWNED BY public.escuelas.id_esc;


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tareas; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tareas (
    id_tarea integer NOT NULL,
    nombre character varying,
    instrucciones character varying,
    curso_id integer
);


--
-- Name: tareas_id_tarea_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tareas_id_tarea_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tareas_id_tarea_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tareas_id_tarea_seq OWNED BY public.tareas.id_tarea;


--
-- Name: tipo_usuarios; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tipo_usuarios (
    tipousu_id integer NOT NULL,
    role_descr character varying(255),
    role character varying(255)
);


--
-- Name: usu_cursos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.usu_cursos (
    id_usucursos integer NOT NULL,
    usu_id integer,
    id_cursos integer
);


--
-- Name: usu_cursos_id_usucursos_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.usu_cursos_id_usucursos_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: usu_cursos_id_usucursos_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.usu_cursos_id_usucursos_seq OWNED BY public.usu_cursos.id_usucursos;


--
-- Name: usuario_permiso; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.usuario_permiso (
    id_usu integer NOT NULL,
    id_role integer NOT NULL
);


--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.usuarios (
    email character varying(255),
    nom character varying(255),
    password character varying(61) NOT NULL,
    tel integer,
    usu character varying(255),
    status character varying,
    usu_id integer NOT NULL,
    id_role integer,
    id_sep character varying,
    escolaridad character varying,
    grado integer
);


--
-- Name: usuarios_usu_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.usuarios_usu_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: usuarios_usu_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.usuarios_usu_id_seq OWNED BY public.usuarios.usu_id;


--
-- Name: cursos id_cursos; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.cursos ALTER COLUMN id_cursos SET DEFAULT nextval('public.cursos_id_cursos_seq'::regclass);


--
-- Name: escuelas id_esc; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.escuelas ALTER COLUMN id_esc SET DEFAULT nextval('public.escuelas_id_esc_seq'::regclass);


--
-- Name: tareas id_tarea; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tareas ALTER COLUMN id_tarea SET DEFAULT nextval('public.tareas_id_tarea_seq'::regclass);


--
-- Name: usu_cursos id_usucursos; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usu_cursos ALTER COLUMN id_usucursos SET DEFAULT nextval('public.usu_cursos_id_usucursos_seq'::regclass);


--
-- Name: usuarios usu_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN usu_id SET DEFAULT nextval('public.usuarios_usu_id_seq'::regclass);


--
-- Data for Name: cursos; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.cursos (id_cursos, nombre, id_usuarios, escolaridad, grado, periodo, grupo, examen, tarea) FROM stdin;
1	matematicas	6	\N	\N	\N	\N	\N	\N
2	informatica	10	\N	\N	\N	\N	\N	\N
3	informatica	10	\N	\N	\N	\N	\N	\N
4	informatica	10	\N	\N	\N	\N	\N	\N
5	informatica	6	\N	\N	\N	\N	\N	\N
7	\N	15	\N	0	\N	\N	\N	\N
8	\N	15	\N	0	\N	\N	\N	\N
9	mate	15	secu	3	2020-05-07	a	\N	\N
10	Matematicas	15	secundaria	2	2020-05-08	a	\N	\N
11	mate2	15	secundaria	2	2020-05-13	b	\N	\N
\.


--
-- Data for Name: escuelas; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.escuelas (id_esc, id_sep, nombre) FROM stdin;
1	12a	america
\.


--
-- Data for Name: tareas; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.tareas (id_tarea, nombre, instrucciones, curso_id) FROM stdin;
4	\N	\N	7
5	\N	\N	7
6	ta1	hacer uno	7
7	ta1	hacer uno	7
8	ta1	hacer uno	7
9	ta4	hacer5	7
10	ta10	hacer 10	7
11	ta5	kaa kaka	7
12	tax	prueba	7
13	aaa	aa	7
14	bb	b	7
15	ss	s	7
16	s	s	7
17	m	hacer uno	7
\.


--
-- Data for Name: tipo_usuarios; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.tipo_usuarios (tipousu_id, role_descr, role) FROM stdin;
1	super_user	ADMIN
2	puede arreglar transacciones	profesor
3	solo entrar en web	alumno
\.


--
-- Data for Name: usu_cursos; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.usu_cursos (id_usucursos, usu_id, id_cursos) FROM stdin;
2	15	11
\.


--
-- Data for Name: usuario_permiso; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.usuario_permiso (id_usu, id_role) FROM stdin;
\.


--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.usuarios (email, nom, password, tel, usu, status, usu_id, id_role, id_sep, escolaridad, grado) FROM stdin;
bluedivee@hotmail.com	nefi	dimi	333	dimitri	\N	1	2	\N	\N	\N
ava@yahoo.com	ava	ava	555	ava	verified	2	3	\N	\N	\N
mal@yahoo.com	mal	mal	333	mal	verified	3	2	\N	\N	\N
finegar@gmail	nef	nef	444	nef	block	4	3	\N	\N	\N
nefgtz@hotmail.com	kalel	kalel	444	kalel	verified	5	2	\N	\N	\N
moroformat@yahoo.com	moro	$2a$10$5eRqvLVOXnKO4JQVahnH1urE6fMMaOl7IcBFt0k3x2d9iAJKMqBrm	0	\N	verified	6	2	\N	\N	\N
		$2a$10$2ylwRodvGwqCaEIS5iYvwu1b/yTNmDoimPW15zn0KDmrC4o7omEKC	0	\N	verified	7	3	\N	\N	\N
		$2a$10$q0dw3gNL/Ouo8QqfjkE1mOyba0WZpNPxmauQc8Q7Qe5rApRTu1Hay	0	\N	verified	8	2	\N	\N	\N
	j	$2a$10$snv975KzYLYe2FAgZ/rbv.xBWawMQBZsJOfGHQ2FQvpDTe9BnFRmK	0	\N	verified	9	2	\N	\N	\N
bluedivee@hotmail.com	nefi	$2a$10$8MYZXk6USC7N9nLGXkqBoOQiyRxy5./oTErN9AY0GoZQ/P16q3Nw.	0	\N	verified	10	3	\N	\N	\N
p@p	p	$2a$10$20g4vWvrUNHO/Pz1DOKvPe3dDK4AKCI6JXM5DUV1k1BGh78PrwVlq	0	\N	verified	11	2	\N	\N	\N
n@n	nefi	$2a$10$Oa9avl6ku86nT4.1/uVU2ueSDoM.Wk901/tN0kl4F2FGpPi61kkY.	0	\N	verified	14	3	\N	\N	\N
m@m	maga	$2a$10$Y9eIF7VDw2w85BzswL33Te.wH/RykTJfHioVF/nY45zRKXXsw5bfu	0	\N	verified	15	2	\N	\N	\N
k@k	ka	$2a$10$LSIX5vK1yY9WghWviRWB6.m6VYCSKvSwCTEiUM.206vF2NJjyuFRa	0	\N	verified	16	3	12a	secundaria	2
r@r	richi	$2a$10$jLm0lYAsqR8S88USI5.EXe249q6KLmY4TrAIjZ2d9ehlT2dGGMBhC	0	\N	verified	17	3	12a	secundaria	3
\.


--
-- Name: cursos_id_cursos_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.cursos_id_cursos_seq', 11, true);


--
-- Name: escuelas_id_esc_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.escuelas_id_esc_seq', 1, true);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.hibernate_sequence', 17, true);


--
-- Name: tareas_id_tarea_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.tareas_id_tarea_seq', 1, false);


--
-- Name: usu_cursos_id_usucursos_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.usu_cursos_id_usucursos_seq', 2, true);


--
-- Name: usuarios_usu_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.usuarios_usu_id_seq', 17, true);


--
-- Name: cursos cursos_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.cursos
    ADD CONSTRAINT cursos_pkey PRIMARY KEY (id_cursos);


--
-- Name: escuelas escuelas_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.escuelas
    ADD CONSTRAINT escuelas_pkey PRIMARY KEY (id_sep);


--
-- Name: tareas tareas_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tareas
    ADD CONSTRAINT tareas_pkey PRIMARY KEY (id_tarea);


--
-- Name: tipo_usuarios tipo_usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tipo_usuarios
    ADD CONSTRAINT tipo_usuarios_pkey PRIMARY KEY (tipousu_id);


--
-- Name: usu_cursos usu_cursos_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usu_cursos
    ADD CONSTRAINT usu_cursos_pkey PRIMARY KEY (id_usucursos);


--
-- Name: usuario_permiso usuario_permiso_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuario_permiso
    ADD CONSTRAINT usuario_permiso_pkey PRIMARY KEY (id_usu, id_role);


--
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (usu_id);


--
-- Name: cursos cursos_id_usuarios_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.cursos
    ADD CONSTRAINT cursos_id_usuarios_fkey FOREIGN KEY (id_usuarios) REFERENCES public.usuarios(usu_id);


--
-- Name: usuario_permiso fk1069dgd5knmfgk7486ijner38; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuario_permiso
    ADD CONSTRAINT fk1069dgd5knmfgk7486ijner38 FOREIGN KEY (id_usu) REFERENCES public.usuarios(usu_id);


--
-- Name: usuario_permiso fk2yceh1rnbuel51iy5909kpc9; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuario_permiso
    ADD CONSTRAINT fk2yceh1rnbuel51iy5909kpc9 FOREIGN KEY (id_role) REFERENCES public.tipo_usuarios(tipousu_id);


--
-- Name: usu_cursos fkbsj3ciro4ocu6gocqismsgpur; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usu_cursos
    ADD CONSTRAINT fkbsj3ciro4ocu6gocqismsgpur FOREIGN KEY (id_cursos) REFERENCES public.usuarios(usu_id);


--
-- Name: tareas tareas_curso_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tareas
    ADD CONSTRAINT tareas_curso_id_fkey FOREIGN KEY (curso_id) REFERENCES public.cursos(id_cursos);


--
-- Name: usu_cursos usu_cursos_id_cursos_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usu_cursos
    ADD CONSTRAINT usu_cursos_id_cursos_fkey FOREIGN KEY (id_cursos) REFERENCES public.cursos(id_cursos);


--
-- Name: usu_cursos usu_cursos_usu_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usu_cursos
    ADD CONSTRAINT usu_cursos_usu_id_fkey FOREIGN KEY (usu_id) REFERENCES public.usuarios(usu_id);


--
-- Name: usuarios usuarios_id_role_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_id_role_fkey FOREIGN KEY (id_role) REFERENCES public.tipo_usuarios(tipousu_id);


--
-- Name: usuarios usuarios_id_sep_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_id_sep_fkey FOREIGN KEY (id_sep) REFERENCES public.escuelas(id_sep);


--
-- PostgreSQL database dump complete
--

