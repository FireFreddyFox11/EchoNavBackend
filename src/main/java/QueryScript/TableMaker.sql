--WARNING--
--THIS QUERY SHOULD ONLY BE EXECUTED ONCE--
--IF THE TABLE CONTAINS ERRORS THEY NEED TO BE HANDLED MANUALLY--

--DELETES ALL THE TABLES SO THEY DON'T CAUSE UPDATE ANOMALIES--
DROP TABLE IF EXISTS organisations, buildings, floorPlans, nodes, Staff, VIUsers, staff_invites, Pairing_Pins, edges, EdgeToNodeConnection, beacons, Deployment_Tasks CASCADE;

-- 1. Organizations (Root)
CREATE TABLE organisations (
                               id SERIAL PRIMARY KEY,
                               orgName VARCHAR(255) NOT NULL,
                               adminName VARCHAR(255),
                               orgEmail VARCHAR(255) UNIQUE,
                               orgPassword VARCHAR(255),
                               slug VARCHAR(100),
                               country VARCHAR(100),
                               address TEXT,
                               contactNo VARCHAR(50),
                               created_at TIMESTAMPTZ DEFAULT NOW(),
                               updated_at TIMESTAMPTZ DEFAULT NOW()
);

-- 2. Buildings
CREATE TABLE buildings (
                           id SERIAL PRIMARY KEY,
                           organisationID INTEGER REFERENCES organisations(id) ON DELETE CASCADE,
                           name VARCHAR(255) NOT NULL,
                           address TEXT,
                           privacy_level VARCHAR(50),
                           created_at TIMESTAMPTZ DEFAULT NOW(),
                           updated_at TIMESTAMPTZ DEFAULT NOW()
);

-- 3. Floor Plans
CREATE TABLE floorPlans (
                            id SERIAL PRIMARY KEY,
                            orgID INTEGER REFERENCES organisations(id),
                            buildingID INTEGER REFERENCES buildings(id) ON DELETE CASCADE,
                            name VARCHAR(255),
                            floorPlanSVG TEXT,
                            scale FLOAT,
                            access VARCHAR(50),
                            created_at TIMESTAMPTZ DEFAULT NOW(),
                            updated_at TIMESTAMPTZ DEFAULT NOW()
);

-- 4. Nodes
CREATE TABLE nodes (
                       id SERIAL PRIMARY KEY,
                       floorPlanID INTEGER REFERENCES floorPlans(id) ON DELETE CASCADE,
                       label VARCHAR(255),
                       x FLOAT NOT NULL,
                       y FLOAT NOT NULL,
                       tts_verbal_guidance TEXT,
                       created_at TIMESTAMPTZ DEFAULT NOW()
);

-- 5. Staff
CREATE TABLE Staff (
                       id SERIAL PRIMARY KEY,
                       organisationID INTEGER REFERENCES organisations(id),
                       pairingPin VARCHAR(10),
                       email VARCHAR(255) UNIQUE,
                       display_name VARCHAR(255),
                       password VARCHAR(255),
                       role VARCHAR(50),
                       status VARCHAR(50),
                       created_at TIMESTAMPTZ DEFAULT NOW(),
                       updated_at TIMESTAMPTZ DEFAULT NOW()
);

-- 6. Visually Impaired Users
CREATE TABLE VIUsers (
                         id SERIAL PRIMARY KEY,
                         pairingPin VARCHAR(10),
                         organisationID INTEGER REFERENCES organisations(id),
                         name VARCHAR(255),
                         surname VARCHAR(255),
                         email VARCHAR(255) UNIQUE,
                         password VARCHAR(255),
                         last_active TIMESTAMPTZ,
                         created_at TIMESTAMPTZ DEFAULT NOW()
);

-- 7. Staff Invites
CREATE TABLE staff_invites (
                               inviteID SERIAL PRIMARY KEY,
                               invitedByID INTEGER REFERENCES Staff(id),
                               organisationID INTEGER REFERENCES organisations(id),
                               profileID INTEGER,
                               expires_at TIMESTAMPTZ,
                               created_at TIMESTAMPTZ DEFAULT NOW()
);

-- 8. Pairing Pins
CREATE TABLE Pairing_Pins (
                              id SERIAL PRIMARY KEY,
                              VIUserID INTEGER REFERENCES VIUsers(id),
                              StaffID INTEGER REFERENCES Staff(id),
                              organisationID INTEGER REFERENCES organisations(id),
                              pin_hash TEXT,
                              created_at TIMESTAMPTZ DEFAULT NOW()
);

-- 9. Edges
CREATE TABLE edges (
                       id SERIAL PRIMARY KEY,
                       fromNodeId INTEGER REFERENCES nodes(id) ON DELETE CASCADE,
                       toNodeId INTEGER REFERENCES nodes(id) ON DELETE CASCADE,
                       mapID INTEGER REFERENCES floorPlans(id),
                       weight_n FLOAT,
                       distance FLOAT,
                       is_hazard BOOLEAN DEFAULT FALSE,
                       created_at TIMESTAMPTZ DEFAULT NOW()
);

-- 10. Edge to Node Connection
CREATE TABLE EdgeToNodeConnection (
                                      nodeId INTEGER REFERENCES nodes(id) ON DELETE CASCADE,
                                      edgeId INTEGER REFERENCES edges(id) ON DELETE CASCADE,
                                      created_at TIMESTAMPTZ DEFAULT NOW(),
                                      PRIMARY KEY (nodeId, edgeId)
);

-- 11. Beacons
CREATE TABLE beacons (
                         id SERIAL PRIMARY KEY,
                         nodeID INTEGER REFERENCES nodes(id) ON DELETE SET NULL,
                         uuid UUID NOT NULL,
                         major INTEGER,
                         minor INTEGER,
                         calibrated_rssi_baseline INTEGER,
                         status VARCHAR(50),
                         linked_date TIMESTAMPTZ
);

-- 12. Deployment Tasks
CREATE TABLE Deployment_Tasks (
                                  id SERIAL PRIMARY KEY,
                                  nodeID INTEGER REFERENCES nodes(id),
                                  staffID INTEGER REFERENCES Staff(id),
                                  status VARCHAR(50),
                                  timeCompleted TIMESTAMPTZ,
                                  timeAssigned TIMESTAMPTZ DEFAULT NOW()
);