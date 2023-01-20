package xenacia.type;

public class CrawlCellUnitType extends UnitType{
    @override
    public TextureRegion[] wreckRegions, segmentRegions, segmentCellRegions, segmentOutlineRegions;
    @override
    public void drawCrawl(Crawlc crawl){
        Unit unit = (Unit)crawl;
        applyColor(unit);

        //change to 2 TODO
        for(int p = 0; p < 2; p++){
            TextureRegion[] regions;
            if(p == 0){
                regions = segmentOutlineRegions;
            }else if(p == 1){
                regions = segmentRegions;
            }else{
                regions = segmentCells;
            }
            for(int i = 0; i < segments; i++){
                float trns = Mathf.sin(crawl.crawlTime() + i * segmentPhase, segmentScl, segmentMag);

                //at segment 0, rotation = segmentRot, but at the last segment it is rotation
                float rot = Mathf.slerp(crawl.segmentRot(), unit.rotation, i / (float)(segments - 1));
                float tx = Angles.trnsx(rot, trns), ty = Angles.trnsy(rot, trns);

                //shadow
                Draw.color(0f, 0f, 0f, 0.2f);
                //Draw.rect(regions[i], unit.x + tx + 2f, unit.y + ty - 2f, rot - 90);

                applyColor(unit);

                //TODO merge outlines?
                Draw.rect(regions[i], unit.x + tx, unit.y + ty, rot - 90);
            }
        }
    }
}