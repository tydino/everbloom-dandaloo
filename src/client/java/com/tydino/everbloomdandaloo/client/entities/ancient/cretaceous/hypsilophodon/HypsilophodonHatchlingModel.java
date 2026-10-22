package com.tydino.everbloomdandaloo.client.entities.ancient.cretaceous.hypsilophodon;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class HypsilophodonHatchlingModel extends EntityModel<HypsilophodonRenderState> {
	private final ModelPart root;
	private final ModelPart egg;
	private final ModelPart dinosaur;
	private final ModelPart chest;
	private final ModelPart neck;
	private final ModelPart headlead;
	private final ModelPart head;
	private final ModelPart leftarm;
	private final ModelPart rightarm;

	final KeyframeAnimation idle;
	final KeyframeAnimation eat;
	final KeyframeAnimation walk;
	final KeyframeAnimation sitDown;
	final KeyframeAnimation sitting;
	final KeyframeAnimation standUp;
	final KeyframeAnimation blinking;

	final KeyframeAnimation scritch;

	public HypsilophodonHatchlingModel(ModelPart root) {
		super(root);
		this.root = root.getChild("root");
		this.egg = this.root.getChild("egg");
		this.dinosaur = this.egg.getChild("dinosaur");
		this.chest = this.dinosaur.getChild("chest");
		this.neck = this.chest.getChild("neck");
		this.headlead = this.neck.getChild("headlead");
		this.head = this.headlead.getChild("head");
		this.leftarm = this.chest.getChild("leftarm");
		this.rightarm = this.chest.getChild("rightarm");

		this.idle = HypsilophodonHatchlingAnimations.idle.bake(root);
		this.eat = HypsilophodonHatchlingAnimations.idle.bake(root);
		this.walk = HypsilophodonHatchlingAnimations.walk.bake(root);
		this.sitDown = HypsilophodonHatchlingAnimations.sit.bake(root);
		this.sitting = HypsilophodonHatchlingAnimations.sitting.bake(root);
		this.standUp = HypsilophodonHatchlingAnimations.stand.bake(root);
		this.blinking = HypsilophodonHatchlingAnimations.blink.bake(root);

		this.scritch = HypsilophodonHatchlingAnimations.scritch.bake(root);
	}
	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition root = modelPartData.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition egg = root.addOrReplaceChild("egg", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition dinosaur = egg.addOrReplaceChild("dinosaur", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chest = dinosaur.addOrReplaceChild("chest", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition cube_r1 = chest.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.0F, 1.5F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r2 = neck.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(10, 2).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -1.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition headlead = neck.addOrReplaceChild("headlead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition head = headlead.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 18).addBox(-1.5F, -1.0436F, -1.5019F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(9, 14).addBox(-1.0F, -2.0436F, -1.0019F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -0.5F));

		PartDefinition leftarm = chest.addOrReplaceChild("leftarm", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.0F, -1.0F));

		PartDefinition cube_r3 = leftarm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(7, 0).addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 1.0F, 1.0F, -0.1745F, 0.0F, 0.6109F));

		PartDefinition rightarm = chest.addOrReplaceChild("rightarm", CubeListBuilder.create(), PartPose.offset(1.0F, -1.0F, -1.0F));

		PartDefinition cube_r4 = rightarm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 5).addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.5F, 1.0F, -0.1745F, 0.0F, -0.6109F));
		return LayerDefinition.create(modelData, 18, 22);
	}

	@Override
	public void setupAnim(HypsilophodonRenderState state) {
		super.setupAnim(state);

		if(state.blinkAnimationState.isStarted()){
			this.blinking.apply(state.blinkAnimationState, state.ageInTicks);
		}

		if(state.idleAnimationState.isStarted()){
			this.idle.apply(state.idleAnimationState, state.ageInTicks);
		}

		if(state.eatAnimationState.isStarted()){
			this.eat.apply(state.eatAnimationState, state.ageInTicks);
		}

		if(state.sittingdownAnimationState.isStarted()){
			this.sitDown.apply(state.sittingdownAnimationState, state.ageInTicks);
		}
		if(state.sitAnimationState.isStarted()){
			this.sitting.apply(state.sitAnimationState, state.ageInTicks);
		}
		if(state.standingupAnimationState.isStarted()){
			this.standUp.apply(state.standingupAnimationState, state.ageInTicks);
		}

		this.walk.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 6f, 18f);

		//head
		this.head.xRot = state.xRot * (float) (Math.PI / 180.0);
		this.head.yRot = state.yRot * (float) (Math.PI / 180.0);
	}
}