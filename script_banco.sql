--
-- PostgreSQL database dump
--

\restrict BhJqvPAP5qTBcK5VTAUowEbwRLbqLwm1m5SQ5fvO8wwhQZnt0mLpCM6RWiS1vx1

-- Dumped from database version 16.14 (Homebrew)
-- Dumped by pg_dump version 16.14 (Homebrew)

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
-- Name: campeonato; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.campeonato (
    id_campeonato integer NOT NULL,
    nome_campeonato character varying(100) NOT NULL,
    ano_edicao integer NOT NULL
);


ALTER TABLE public.campeonato OWNER TO postgres;

--
-- Name: consulta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.consulta (
    id_consulta integer NOT NULL,
    id_pessoa_fisioterapeuta integer NOT NULL,
    id_pessoa_jogador integer NOT NULL,
    id_lesao integer NOT NULL,
    data_consulta timestamp without time zone NOT NULL,
    procedimento_realizado character varying(255),
    observacoes_medicas character varying(255)
);


ALTER TABLE public.consulta OWNER TO postgres;

--
-- Name: disputa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.disputa (
    id_pessoa_jogador integer NOT NULL,
    id_jogo integer NOT NULL,
    minutos_em_quadra integer,
    pontos_marcados integer
);


ALTER TABLE public.disputa OWNER TO postgres;

--
-- Name: estadio; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estadio (
    id_estadio integer NOT NULL,
    nome_estadio character varying(100) NOT NULL,
    capacidade integer,
    cidade character varying(100)
);


ALTER TABLE public.estadio OWNER TO postgres;

--
-- Name: fisioterapeuta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fisioterapeuta (
    id_pessoa integer NOT NULL,
    registro_crefito character varying(20) NOT NULL,
    especialidade character varying(50)
);


ALTER TABLE public.fisioterapeuta OWNER TO postgres;

--
-- Name: jogador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jogador (
    id_pessoa integer NOT NULL,
    posicao character varying(30),
    numero_camisa integer
);


ALTER TABLE public.jogador OWNER TO postgres;

--
-- Name: jogo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jogo (
    id_jogo integer NOT NULL,
    id_campeonato integer NOT NULL,
    id_estadio integer NOT NULL,
    data_hora_jogo timestamp without time zone NOT NULL,
    placar character varying(10)
);


ALTER TABLE public.jogo OWNER TO postgres;

--
-- Name: lesao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lesao (
    id_lesao integer NOT NULL,
    id_pessoa_jogador integer NOT NULL,
    tipo_lesao character varying(100) NOT NULL,
    data_ocorrencia date NOT NULL,
    gravidade character varying(20)
);


ALTER TABLE public.lesao OWNER TO postgres;

--
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pessoa (
    id_pessoa integer NOT NULL,
    nome character varying(100) NOT NULL,
    cpf character varying(11) NOT NULL,
    data_nascimento date
);


ALTER TABLE public.pessoa OWNER TO postgres;

--
-- Data for Name: campeonato; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.campeonato (id_campeonato, nome_campeonato, ano_edicao) FROM stdin;
101	Copa do Mundo	2026
\.


--
-- Data for Name: consulta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.consulta (id_consulta, id_pessoa_fisioterapeuta, id_pessoa_jogador, id_lesao, data_consulta, procedimento_realizado, observacoes_medicas) FROM stdin;
101	123	110	101	2026-06-11 09:30:00	Sessão de liberação miofascial e ultrassom	Paciente relatou alívio da dor, manter acompanhamento.
102	124	113	102	2026-06-16 10:00:00	Aplicação de gelo e bandagem compressiva	Inchaço moderado no local. Recomendado repouso absoluto de 48h.
\.


--
-- Data for Name: disputa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.disputa (id_pessoa_jogador, id_jogo, minutos_em_quadra, pontos_marcados) FROM stdin;
101	101	90	0
107	101	85	1
120	101	90	1
110	101	45	0
104	102	90	0
119	102	30	1
\.


--
-- Data for Name: estadio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estadio (id_estadio, nome_estadio, capacidade, cidade) FROM stdin;
101	Hard Rock Stadium	64767	Miami
102	SoFi Stadium	70240	Los Angeles
103	MetLife Stadium	82500	Nova York
1	Estadio Azteca	83000	Cidade do Mexico
3	BMO Field	30000	Toronto
\.


--
-- Data for Name: fisioterapeuta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fisioterapeuta (id_pessoa, registro_crefito, especialidade) FROM stdin;
122	10002	Quiroprata
123	10003	Muscular
124	10004	Entorces
\.


--
-- Data for Name: jogador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jogador (id_pessoa, posicao, numero_camisa) FROM stdin;
101	Goleiro	1
104	Zagueiro	4
106	Lateral-esquerdo	6
107	Atacante	7
110	Atacante	10
113	Lateral-direito	13
119	Atacante	19
120	Meio-campo	20
121	Atacante	21
500	Atacante	11
\.


--
-- Data for Name: jogo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jogo (id_jogo, id_campeonato, id_estadio, data_hora_jogo, placar) FROM stdin;
101	101	101	2026-06-12 17:00:00	2x0
102	101	102	2026-06-16 20:00:00	1x1
103	101	103	2026-06-20 16:00:00	\N
\.


--
-- Data for Name: lesao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.lesao (id_lesao, id_pessoa_jogador, tipo_lesao, data_ocorrencia, gravidade) FROM stdin;
101	110	Lesao muscular na panturrilha	2026-06-10	Média
102	113	Entorce no tornozelo direito	2026-06-15	Leve
\.


--
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pessoa (id_pessoa, nome, cpf, data_nascimento) FROM stdin;
101	Alisson Becker	10000000001	1992-10-02
104	Marquinhos	10000000004	1994-05-14
106	Alex Sandro	10000000006	1991-01-26
107	Vinícius Júnior	10000000007	2000-07-12
110	Neymar Júnior	10000000010	1992-02-05
113	Danilo	10000000013	1991-07-15
119	Endrick	10000000019	2006-07-21
120	Lucas Paquetá	10000000020	1997-08-27
121	Luiz Henrique	10000000021	2001-01-02
122	Jorge Pato	10000002001	1960-09-22
123	Wynner Reis	10000003241	2000-12-22
124	Julia Rosa	10003000045	2000-12-22
500	Rafinha	123456789	1990-02-16
\.


--
-- Name: campeonato campeonato_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.campeonato
    ADD CONSTRAINT campeonato_pkey PRIMARY KEY (id_campeonato);


--
-- Name: consulta consulta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_pkey PRIMARY KEY (id_consulta);


--
-- Name: disputa disputa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disputa
    ADD CONSTRAINT disputa_pkey PRIMARY KEY (id_pessoa_jogador, id_jogo);


--
-- Name: estadio estadio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estadio
    ADD CONSTRAINT estadio_pkey PRIMARY KEY (id_estadio);


--
-- Name: fisioterapeuta fisioterapeuta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fisioterapeuta
    ADD CONSTRAINT fisioterapeuta_pkey PRIMARY KEY (id_pessoa);


--
-- Name: fisioterapeuta fisioterapeuta_registro_crefito_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fisioterapeuta
    ADD CONSTRAINT fisioterapeuta_registro_crefito_key UNIQUE (registro_crefito);


--
-- Name: jogador jogador_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jogador
    ADD CONSTRAINT jogador_pkey PRIMARY KEY (id_pessoa);


--
-- Name: jogo jogo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jogo
    ADD CONSTRAINT jogo_pkey PRIMARY KEY (id_jogo);


--
-- Name: lesao lesao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lesao
    ADD CONSTRAINT lesao_pkey PRIMARY KEY (id_lesao);


--
-- Name: pessoa pessoa_cpf_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_cpf_key UNIQUE (cpf);


--
-- Name: pessoa pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id_pessoa);


--
-- Name: consulta consulta_id_lesao_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_id_lesao_fkey FOREIGN KEY (id_lesao) REFERENCES public.lesao(id_lesao);


--
-- Name: consulta consulta_id_pessoa_fisioterapeuta_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_id_pessoa_fisioterapeuta_fkey FOREIGN KEY (id_pessoa_fisioterapeuta) REFERENCES public.fisioterapeuta(id_pessoa);


--
-- Name: consulta consulta_id_pessoa_jogador_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_id_pessoa_jogador_fkey FOREIGN KEY (id_pessoa_jogador) REFERENCES public.jogador(id_pessoa);


--
-- Name: disputa disputa_id_jogo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disputa
    ADD CONSTRAINT disputa_id_jogo_fkey FOREIGN KEY (id_jogo) REFERENCES public.jogo(id_jogo);


--
-- Name: disputa disputa_id_pessoa_jogador_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.disputa
    ADD CONSTRAINT disputa_id_pessoa_jogador_fkey FOREIGN KEY (id_pessoa_jogador) REFERENCES public.jogador(id_pessoa);


--
-- Name: fisioterapeuta fisioterapeuta_id_pessoa_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fisioterapeuta
    ADD CONSTRAINT fisioterapeuta_id_pessoa_fkey FOREIGN KEY (id_pessoa) REFERENCES public.pessoa(id_pessoa);


--
-- Name: jogador jogador_id_pessoa_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jogador
    ADD CONSTRAINT jogador_id_pessoa_fkey FOREIGN KEY (id_pessoa) REFERENCES public.pessoa(id_pessoa);


--
-- Name: jogo jogo_id_campeonato_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jogo
    ADD CONSTRAINT jogo_id_campeonato_fkey FOREIGN KEY (id_campeonato) REFERENCES public.campeonato(id_campeonato);


--
-- Name: jogo jogo_id_estadio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jogo
    ADD CONSTRAINT jogo_id_estadio_fkey FOREIGN KEY (id_estadio) REFERENCES public.estadio(id_estadio);


--
-- Name: lesao lesao_id_pessoa_jogador_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lesao
    ADD CONSTRAINT lesao_id_pessoa_jogador_fkey FOREIGN KEY (id_pessoa_jogador) REFERENCES public.jogador(id_pessoa);


--
-- PostgreSQL database dump complete
--

\unrestrict BhJqvPAP5qTBcK5VTAUowEbwRLbqLwm1m5SQ5fvO8wwhQZnt0mLpCM6RWiS1vx1

