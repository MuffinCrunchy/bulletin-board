--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2025-03-20 12:30:56

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
-- TOC entry 216 (class 1259 OID 41219)
-- Name: posts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.posts (
    id integer NOT NULL,
    author character varying(50) NOT NULL,
    password character varying(64) NOT NULL,
    title character varying(100) NOT NULL,
    body text NOT NULL,
    views bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    deleted_at timestamp without time zone
);


ALTER TABLE public.posts OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 41218)
-- Name: posts_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.posts_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.posts_id_seq OWNER TO postgres;

--
-- TOC entry 3398 (class 0 OID 0)
-- Dependencies: 215
-- Name: posts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.posts_id_seq OWNED BY public.posts.id;


--
-- TOC entry 3245 (class 2604 OID 41222)
-- Name: posts id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.posts ALTER COLUMN id SET DEFAULT nextval('public.posts_id_seq'::regclass);


--
-- TOC entry 3392 (class 0 OID 41219)
-- Dependencies: 216
-- Data for Name: posts; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.posts (id, author, password, title, body, views, created_at, updated_at, deleted_at) VALUES (2, '최희영', 'numbertwo', '심리학의 중요성 이해하기', '심리학은 인간의 마음과 행동에 대한 과학적 연구로, 사람들이 왜 그렇게 생각하고, 느끼고, 행동하는지 이해하는 데 도움을 줍니다. 심리학은 감정과 인지부터 사회적 상호작용과 정신 건강에 이르기까지 인간 삶의 다양한 측면을 탐구합니다. 심리학을 공부함으로써 우리는 우리의 생각과 경험이 어떻게 결정을 내리는지에 대한 통찰력을 얻어 관계를 개선하고 생산성을 높이며 정서적 안녕을 유지할 수 있습니다.

심리학의 가장 중요한 응용 분야 중 하나는 정신 건강 분야입니다. 심리학 연구는 불안, 우울증, 스트레스 장애와 같은 질환에 대한 효과적인 치료법으로 이어졌습니다. 인지행동치료(CBT) 및 마음챙김 훈련과 같은 치료 기법은 개인이 어려움에 대처하고 삶의 질을 개선하는 데 도움이 됩니다. 또한 심리학은 직장 환경, 교육, 심지어 마케팅에서도 중요한 역할을 하는데, 인간의 행동을 이해하면 기업과 기관이 사람들에게 더 나은 경험을 제공할 수 있기 때문입니다.

심리학에 대한 이해가 높아지면서 심리학은 기술부터 의학까지 다양한 분야에 영향을 미치고 있습니다. 인공 지능과 행동 과학의 부상은 개인화된 사용자 경험과 더 나은 의료 솔루션으로 이어졌습니다. 그러나 특히 데이터 프라이버시 및 정신 건강 관리와 같은 분야에서는 윤리적 고려가 여전히 중요합니다. 심리학 지식을 책임감 있게 적용함으로써 사회는 인간 본성을 더 깊이 이해하는 동시에 연구와 실제 적용에서 윤리적 관행을 보장함으로써 이익을 얻을 수 있습니다.', 12, '2025-03-20 11:27:06.349', '2025-03-20 11:27:06.349', NULL);
INSERT INTO public.posts (id, author, password, title, body, views, created_at, updated_at, deleted_at) VALUES (4, '최희영', 'numbertwo', '속보: 대규모 태양 플레어, 글로벌 통신을 방해하다', '오늘 새벽 태양에서 강력한 태양 폭발이 발생하여 여러 지역에서 위성 통신, GPS 시스템 및 무선 신호에 광범위한 장애가 발생했습니다. NASA 우주전파예측센터의 과학자들은 X등급으로 분류되는 이번 플레어가 최근 몇 년간 관측된 것 중 가장 강력한 것 중 하나라고 밝혔습니다. 항공사는 내비게이션 문제를 보고했으며, 전력망 운영자는 정전 가능성에 대해 높은 경계를 하고 있습니다. 당국은 앞으로 태양 활동이 더 활발해질 것으로 예상되는 만큼 대중에게 계속 정보를 제공할 것을 촉구하고 있습니다.', 42, '2025-03-20 11:59:46.34', '2025-03-20 11:59:46.34', NULL);
INSERT INTO public.posts (id, author, password, title, body, views, created_at, updated_at, deleted_at) VALUES (5, '태용선', 'numberthree', 'Pope Francis Announces Historic Global Interfaith Summit at the Vatican', 'In a historic move, Pope Francis has announced a global interfaith summit to be held in Vatican City later this year, bringing together religious leaders from Christianity, Islam, Judaism, Buddhism, Hinduism, and other major faiths. The summit aims to promote peace, mutual understanding, and collaboration on global issues such as poverty, climate change, and conflict resolution. Speaking from St. Peter’s Basilica, the Pope emphasized the importance of unity, stating, “Faith should be a force that unites humanity, not divides it.” The Vatican has confirmed that representatives from various religious organizations, scholars, and humanitarian groups will take part in discussions focused on fostering cooperation and addressing common challenges facing the world today.

The announcement has been met with both praise and skepticism. Many see it as a bold step toward greater religious diplomacy, especially in a time of increasing tensions and misunderstandings between different faith communities. Supporters believe the summit could pave the way for stronger interfaith relations and collective action on humanitarian crises. However, critics question whether dialogue alone can resolve deep-rooted religious and political conflicts. Despite differing opinions, the Vatican remains optimistic that this event will encourage meaningful conversations and inspire global efforts toward peace and solidarity. The summit is expected to draw significant international attention and could mark a turning point in the role of religious institutions in addressing global challenges.', 22, '2025-03-20 12:03:15.225', '2025-03-20 12:24:46.972', NULL);
INSERT INTO public.posts (id, author, password, title, body, views, created_at, updated_at, deleted_at) VALUES (3, '조경미', 'numberone', 'Scientists Detect Mysterious Deep-Space Signal, Raising Questions About Alien Life', 'Astronomers have detected a strange, repeating radio signal from a distant star system nearly 50 light-years away, sparking speculation about its origin. The signal, first picked up in early March by a deep-space observatory, follows a structured pattern that does not match any known natural cosmic phenomenon. Scientists have ruled out interference from satellites or pulsars, leading some experts to consider the possibility of an artificial source. Dr. Michael Carter, the lead researcher, stated, "While we are not jumping to conclusions, the complexity of this signal is unlike anything we''ve encountered before."

The discovery has fueled intense debate among scientists and space enthusiasts, with some suggesting it could be an attempt at communication from an advanced civilization. Others urge caution, emphasizing that more data is needed before making definitive claims. International space agencies, including NASA and the European Space Agency, have been called to assist in further analysis. Follow-up observations are planned in the coming weeks to determine the true nature of the signal. Whether this marks a breakthrough in the search for extraterrestrial life or an unidentified cosmic phenomenon, the world eagerly awaits the next update.', 6, '2025-03-20 11:29:56.419', '2025-03-20 11:29:56.419', '2025-03-20 12:19:08.521');
INSERT INTO public.posts (id, author, password, title, body, views, created_at, updated_at, deleted_at) VALUES (10, '태용선', 'numberthree', '속보: 남아프리카에서 발견된 신비한 분화구, 과학계의 열광을 불러일으키다', '남아프리카의 과학자들과 지역 당국은 칼라하리 사막 근처의 외딴 지역에서 하룻밤 사이에 나타난 거대한 분화구를 조사하고 있습니다. 폭이 거의 50m에 달하는 이 설명할 수 없는 분화구는 운석 충돌부터 비밀스러운 지하 활동까지 다양한 이론이 제기되며 그 기원에 대한 추측을 불러일으켰습니다. 주민들은 이른 시간에 폭발과 같은 큰 소리를 들었다고 보고했지만 지진 활동은 기록되지 않았습니다. 지질학자와 천문학자들로 구성된 팀이 현장을 조사하기 위해 파견되었으며, 초기 조사 결과 이 지역에서 흔히 볼 수 없는 특이한 광물 성분이 발견되었습니다. 일부 음모론자들은 이것이 외계인 활동의 증거일 수 있다고 생각하는 반면, 다른 사람들은 공개되지 않은 채굴 작업의 결과일 수 있다고 주장합니다. 당국은 조사가 계속되는 동안 해당 지역을 봉쇄했으며, 대중은 답을 간절히 기다리고 있습니다.', 12, '2025-03-20 12:18:25.615', '2025-03-20 12:19:56.343', '2025-03-20 12:20:08.958');
INSERT INTO public.posts (id, author, password, title, body, views, created_at, updated_at, deleted_at) VALUES (9, '최희영', 'numbertwo', '플래시 뉴스: 서울에서 버스 충돌 사고로 다수의 부상자 발생', '오늘 아침 서울 도심에서 심각한 버스 사고가 발생해 승객과 보행자를 포함해 최소 15명이 부상당했습니다. 현지 당국에 따르면 버스는 강남의 번잡한 교차로 근처에서 통제력을 잃고 여러 대의 차량과 충돌한 후 멈췄습니다. 응급 구조대가 신속하게 도착해 부상자들을 인근 병원으로 이송했으며, 2명은 위독한 상태인 것으로 알려졌습니다. 경찰은 현재 사고 원인을 조사 중이며, 초기 보고에 따르면 브레이크 고장이 원인일 가능성이 있다고 합니다. 사고 수습 작업이 계속되면서 해당 지역의 교통은 여전히 극심한 혼잡을 빚고 있습니다.', 33, '2025-03-20 12:16:22.196', '2025-03-20 12:16:22.196', NULL);
INSERT INTO public.posts (id, author, password, title, body, views, created_at, updated_at, deleted_at) VALUES (7, '태용선', 'numberthree', '소더 칠드런의 실종: 잊혀지지 않는 미스터리', '1945년 크리스마스 이브, 웨스트버지니아주 페이엣빌에 있는 소더 가족의 집이 화염에 휩싸였습니다. 조지 소더와 제니 소더는 10명의 자녀 중 4명은 가까스로 탈출했지만 나머지 5명은 끝내 찾지 못했습니다. 당국은 아이들이 화재로 사망했다고 주장했지만, 유골은 발견되지 않아 불안한 의문이 제기되었습니다. 일부에서는 무솔리니에 대한 노골적인 비판자였던 조지가 이탈리아 현지 동조자들로부터 협박을 받았기 때문에 화재가 우연이 아닐 것이라고 추측했습니다. 정치적 보복이 있었던 것일까요? 한 목격자는 그날 밤 한 무리의 남자들이 집을 지켜보는 것을 봤다고 주장했고, 또 다른 목격자는 실종된 아이들이 과속하는 차를 타고 사라지는 것을 봤다고 신고했습니다.

몇 년 후, 미스터리는 더욱 깊어졌습니다. 소더 부부는 성인이 된 실종된 아들 중 한 명의 사진으로 추정되는 비밀스러운 사진을 우편으로 받았습니다. 뒷면에 적힌 메시지는 “루이스 소더. 프랭키 형 사랑해. 일리 보이즈. A90132 또는 35.” 필적 전문가들은 당황했고, 일부는 이 편지가 정교한 사기극이라고 믿었습니다. 다른 사람들은 아이들이 인신매매 조직의 일원으로 다른 가족에 의해 납치되어 자랐다는 가설을 세웠습니다. 심지어 어두운 비밀을 들키지 않기 위해 이탈리아로 데려가 숨겨둔 것이라는 주장도 있었습니다. 소더 부부는 사설 탐정을 고용하고 포상금을 제시했지만 확실한 답을 찾지 못했습니다.

이 사건은 오늘날까지도 미국 역사상 가장 당혹스러운 미해결 미스터리 중 하나로 남아 있습니다. 아이들이 화재로 사망했을까요, 아니면 사악한 음모에 의해 납치되었을까요? 유골, 목격자 증언, 섬뜩한 편지의 부재로 인해 수십 년 동안 추측이 난무했습니다. 어떤 사람들은 지역 당국에 의해 진실이 은폐되었다고 믿는 반면, 다른 사람들은 소더 아이들이 자신의 과거를 알지 못한 채 새로운 신분을 갖고 살았을 것이라고 주장합니다. 결정적인 증거가 없는 상황에서 실종된 소더 아이들의 운명은 미스터리를 풀고자 하는 사람들을 계속 괴롭히고 있습니다.', 6, '2025-03-20 12:12:11.845', '2025-03-20 12:12:11.845', '2025-03-20 12:21:21.83');
INSERT INTO public.posts (id, author, password, title, body, views, created_at, updated_at, deleted_at) VALUES (1, '조경미', 'numberone', 'The Impact of Technology on Modern Society', 'Technology has revolutionized the way we live, work, and interact with the world. From smartphones to artificial intelligence, technological advancements continue to shape industries and improve daily life. The rise of automation and digital tools has increased efficiency, enabling businesses to streamline operations and enhance productivity. Additionally, innovations in communication, such as social media and instant messaging, have connected people across the globe, making information more accessible than ever.

One of the most significant contributions of technology is in healthcare and education. Medical advancements, such as AI-driven diagnostics and robotic surgeries, have improved patient outcomes and extended human lifespans. In education, digital learning platforms and online courses have made knowledge more accessible, allowing students from different backgrounds to gain valuable skills. These developments demonstrate how technology has the power to break barriers and create opportunities for a better future.

Despite its benefits, technology also presents challenges, such as cybersecurity threats, data privacy concerns, and the risk of job displacement due to automation. It is essential to balance innovation with ethical considerations to ensure responsible usage. By addressing these challenges through regulations and education, society can continue to benefit from technological progress while minimizing its negative impact. As technology evolves, it will be crucial to harness its potential for the greater good, ensuring a sustainable and inclusive future.', 26, '2025-03-20 11:23:19.69', '2025-03-20 12:21:43.6', NULL);
INSERT INTO public.posts (id, author, password, title, body, views, created_at, updated_at, deleted_at) VALUES (8, '조경미', 'numberone', 'South Korea Announces Major Reforms to Ease Academic Pressure on Students', 'The South Korean government has unveiled a new set of education reforms aimed at reducing academic stress and promoting a healthier learning environment for students. Known for its highly competitive education system, South Korea has long faced criticism for intense study schedules, long hours at private academies (hagwons), and the immense pressure placed on students to succeed in university entrance exams. The Ministry of Education announced plans to limit hagwon operating hours, revise the college entrance exam structure, and introduce more creative and experiential learning opportunities in schools. Officials hope these measures will help students achieve a better balance between academics and personal well-being.

The reforms have sparked mixed reactions among parents, educators, and students. Some welcome the changes, believing they will improve mental health and allow students to explore diverse career paths beyond traditional academic excellence. Others worry that reducing study hours may lower South Korea’s global competitiveness in education. Despite the debates, the government remains committed to addressing the issue, emphasizing that long-term success should not come at the cost of students'' well-being. As the new policies take effect, the nation will closely watch how these reforms reshape the future of education in South Korea', 10, '2025-03-20 12:14:14.387', '2025-03-20 12:14:14.387', NULL);
INSERT INTO public.posts (id, author, password, title, body, views, created_at, updated_at, deleted_at) VALUES (6, '태용선', 'numberthree', '노숙자에서 하버드까지: 리즈 머레이의 감동적인 여정', '리즈 머레이의 삶은 어릴 적부터 고난으로 가득했습니다. 브롱크스의 마약 중독 부모 사이에서 태어난 그녀는 먹을 것이 부족한 불안정한 가정에서 자랐고, 사랑은 종종 투쟁에 가려졌습니다. 15세가 되자 부모님은 모두 돌아가셨고, 그녀는 노숙자가 되어 지하철과 공원 벤치에서 잠을 자게 되었습니다. 이러한 엄청난 어려움 속에서도 리즈는 자신의 꿈을 포기하지 않았습니다. 그녀는 교육이 자신의 탈출구라는 것을 알았기 때문에 매일의 생존 투쟁과 싸우면서 고등학교에 복학하기로 용기 있는 결정을 내렸습니다.

리즈는 갈 곳이 없어 복도와 계단에서 공부하는 경우가 많았지만, 결단력과 끊임없는 노력으로 고등학교 4년을 단 2년 만에 마쳤습니다. 그녀의 헌신적인 노력은 선생님들의 관심을 끌었고, 선생님들은 장학금 신청을 권유했습니다. 그녀는 명망 있는 뉴욕 타임즈 장학금을 신청하여 수상했고, 하버드 대학교의 문을 열었습니다. 모든 역경을 딛고 기본적인 생존을 위해 고군분투하던 노숙자 소녀는 이제 세계에서 가장 권위 있는 기관의 복도를 걷고 있습니다.

리즈의 이야기는 회복탄력성과 자기 신념의 힘을 보여주는 증거입니다. 나중에 그녀는 동기부여 연설가가 되어 자신의 여정을 통해 다른 사람들에게 영감을 주고 극복하기에는 너무 큰 장애물은 없다는 것을 증명했습니다. 그녀의 삶은 환경이 우리를 정의하는 것이 아니라 더 나은 미래를 위해 싸우겠다는 결심과 의지가 우리를 정의한다는 사실을 일깨워줍니다. 오늘날에도 그녀는 교육을 옹호하고 다른 사람들이 빈곤의 굴레에서 벗어날 수 있도록 돕고 있으며, 인내하면 무엇이든 가능하다는 것을 증명하고 있습니다.', 17, '2025-03-20 12:06:40.547', '2025-03-20 12:23:50.13', NULL);


--
-- TOC entry 3399 (class 0 OID 0)
-- Dependencies: 215
-- Name: posts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.posts_id_seq', 10, true);


--
-- TOC entry 3247 (class 2606 OID 41226)
-- Name: posts posts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.posts
    ADD CONSTRAINT posts_pkey PRIMARY KEY (id);


-- Completed on 2025-03-20 12:30:57

--
-- PostgreSQL database dump complete
--

