import { Subcontent } from "./Subcontent";
import { Ad } from "./Ad";
import { Nav } from "./Nav";


export const Main = () => {
    return (
        <div style={{ display: 'flex', justifyContent: 'space-between', gap: '20px' }}>
            <Nav />
            <div style={{ backgroundColor: '#df6768', width: '80%', height: '80vh', display: 'flex', flexDirection: 'column', padding: '20px, 0px, 20px, 0px' }}>
                <div style={{ width: '100%', display: "flex", justifyContent: 'space-around' }}>
                    <Subcontent />
                    <Subcontent />
                    <Subcontent />
                </div>
                <div>
                    <Ad />
                </div>
            </div>
        </div>
    );
};
