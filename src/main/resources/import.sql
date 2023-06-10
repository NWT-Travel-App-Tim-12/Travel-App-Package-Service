CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

insert into currencies (name) values ('BAM'), ('USD'), ('EUR'), ('GBP');

insert into service_types (name) values ('ACCOMMODATION'), ('MEAL'), ('TRANSPORT'), ('EXCURSION');

insert into regions ("name", notes, currency_id, super_region_id) values ('Bosnia', 'Urban region', 1, null), ('Kakanj', 'Mountains', 1, 1), ('France', 'Europe', 3, null), ('Paris', 'City', 1, 3);

insert into packages (agency_uuid, agent_id, created_at, description, "name", package_code, valid_from, valid_to, region_id) values ('64da5ad1-b828-4987-86af-c4d38ec21a33', 1, NOW(), 'Travel to Paris', 'Paris travel', 'PT123', TO_DATE('2023-03-03', 'YYYY-MM-DD'), TO_DATE('2023-12-03', 'YYYY-MM-DD'), 3), ('35307f4e-4dc7-4493-bdf4-2d1a9b115fd7', 1, NOW(), 'Travel to Kakanj', 'Kakanj travel', 'KT123', TO_DATE('2023-03-03', 'YYYY-MM-DD'), TO_DATE('2023-12-03', 'YYYY-MM-DD'), 1);

insert into services (agent_id, "cost", created_at, description, "name", service_code, region_id, service_type_id, additional_data) values (1, 255, NOW(), 'visit to lovre', 'lovre visit', 'LV_visit', 3, 4, '{"tour_guide_name": "meho"}'), (2, 555, NOW(), 'room in grand hotel', 'hotel', 'H_123', 1, 1, '{"number_of_beds": 2, "pet_friendly": false, "accommodation_raiting": 5, "capacity": 2}'), (3, 11, NOW(), 'voznja tramvajom', 'voznja', 'T_1', 1, 3, '{"vehicle_type": "tram", "capacity": 50}'), (4, 100, NOW(), 'vecera kod brajlovica', 'janjetina', 'M_1', 1, 2, '{"meal_type": "dinner", "is_vegetarian": false, "is_halal": true}');

insert into package_services (package_id, service_id) values (1,2), (1,3), (1,4), (2,1), (2,2), (2,3), (2,4);
