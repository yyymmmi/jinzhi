package com.coding.service;

        import com.coding.domain.Artificialdata;
        import com.coding.domain.User;
        import com.coding.mapper.ArtificialDataMapper;
        import com.guanweiming.common.utils.Result;
        import lombok.AllArgsConstructor;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.stereotype.Service;
        import org.springframework.util.CollectionUtils;

        import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ArtificialDataService {

    private final ArtificialDataMapper artifitialDataMapper;

    public Result<Artificialdata> addData(String disease_loc, String disease_data, String disease_evaluate, String supplementary_notes, String inspection_time, String inspector_id,Long id) {

        Artificialdata record = new Artificialdata();
        record.setDiseaseLoc(disease_loc);
        record.setDiseaseData(disease_data);
        record.setDiseaseEvaluate(disease_evaluate);
        record.setSupplementaryNotes(supplementary_notes);
        record.setInspectionTime(inspection_time);
        record.setInspectorId(inspector_id);
        record.setId(id);
        int resultCount = artifitialDataMapper.insertSelective(record);
        return resultCount == 0 ? Result.createByErrorMessage("添加失败") : Result.createBySuccess(record);
    }

    public Result<Artificialdata> updateData(String disease_loc, String disease_data, String disease_evaluate, String supplementary_notes, String inspection_time, String inspector_id, Long id) {
        Artificialdata record = new Artificialdata();
        record.setId(id);
        List<Artificialdata> list = artifitialDataMapper.select(record);
        if (CollectionUtils.isEmpty(list)) {
            return Result.createByErrorMessage("人工巡检数据不存在无法修改");
        }

        record.setDiseaseLoc(disease_loc);
        record.setDiseaseData(disease_data);
        record.setDiseaseEvaluate(disease_evaluate);
        record.setSupplementaryNotes(supplementary_notes);
        record.setInspectionTime(inspection_time);
        record.setInspectorId(inspector_id);

        int resultCount = artifitialDataMapper.updateByPrimaryKeySelective(record);
        return resultCount == 0 ? Result.createByErrorMessage("更新失败") : Result.createBySuccess(record);

    }
}
